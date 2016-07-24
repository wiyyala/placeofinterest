package com.place.interest.service.converters;

import com.place.interest.domain.Photo;
import com.place.interest.domain.Temple;
import com.place.interest.domain.TempleData;
import com.place.interest.domain.googlePlacesApi.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component("googleResultConverter")
public class GoogleResultConverter {

    private static final String MESSAGE = "Name of the temple : %s " + System.lineSeparator() + " Latitude : %s " + System.lineSeparator() + " Longitude : %s";
    private static final List<String> NAMES = Arrays.asList("temple", "mandir");
    private static final Logger logger = LoggerFactory.getLogger(GoogleResultConverter.class);


    public TempleData getTempleData(GooglePlaceDetailsResult googlePlaceDetailsResult) {
        Result result = googlePlaceDetailsResult.getResult();
        TempleData templeData = new TempleData();
        Temple temple = new Temple();
        temple.setAddress(result.getFormatted_address());
        temple.setPhoneNumber(result.getFormatted_phone_number());
        temple.setInternationlPhoneNumber(result.getInternational_phone_number());
        temple.setName(result.getName());
        List<Photo> photos = temple.getPhotos();
        List<com.place.interest.domain.googlePlacesApi.Photo> resultPhotos = result.getPhotos();
        if (thisExists(resultPhotos)) {
            resultPhotos
                    .stream()
                    .forEach(photo -> {
                        Photo returnPhoto = new Photo();
                        returnPhoto.setHeight(photo.getHeight());
                        returnPhoto.setWidth(photo.getWidth());
                        returnPhoto.setReference(photo.getPhoto_reference());
                        returnPhoto.setHtmlAttributions(photo.getHtml_attributions());
                        photos.add(returnPhoto);
                    });
        }
        temple.setPhotos(photos);
        temple.setPlaceId(result.getPlace_id());
        temple.setMapsUrl(result.getUrl());
        temple.setWebsite(result.getWebsite());
        List<Temple> temples = templeData.getTemples();
        temples.add(temple);
        return templeData;
    }

    public TempleData getTempleData(GoogleNearBySearchResults results) {

        List<Result> resultList = results.getResults();
        TempleData templeData = new TempleData();
        List<Temple> temples = templeData.getTemples();
        if (thisExists(resultList)) {
            resultList.stream()
                    .filter((t) -> isTypeAllowed(t.getTypes(), t.getName()))
                    .forEach(r -> {
                        Temple temple = new Temple();
                        BigDecimal latitude = r.getGeometry().getLocation().getLat();
                        BigDecimal longitude = r.getGeometry().getLocation().getLng();
                        temple.setName(r.getName());
                        temple.setLatitude(latitude);
                        temple.setLongitude(longitude);
                        temple.setPlaceId(r.getPlace_id());
                        logger.info(String.format(MESSAGE, r.getName(), latitude, longitude));
                        temples.add(temple);
                    });
        }
        return templeData;
    }

    public void getTempleData(GoogleNameSearchResult result, TempleData templeData) {
        List<Prediction> predictions = result.getPredictions();
        if(thisExists(predictions)){
            predictions
                    .stream()
                    .filter(prediction -> hasExpectedName(prediction.getDescription()))
                    .forEach(prediction -> {
                        Temple temple = new Temple();
                        temple.setName(prediction.getDescription());
                        temple.setPlaceId(prediction.getPlace_id());
                        templeData.getTemples().add(temple);
                    });
        }
    }

    private boolean isTypeAllowed(List<String> types, String name) {
        if(types.contains("hindu_temple")){
            return true;
        }

        if(hasExpectedName(name)){
            return true;
        }

        return false;
    }

    private boolean hasExpectedName(String name) {
        return NAMES
                .stream()
                .filter(name.toLowerCase()::contains)
                .findAny()
                .isPresent();
    }

    private boolean thisExists(List givenList) {
        return givenList != null;
    }
}
