package com.place.interest.service;

import com.place.interest.adapters.PlacesAdapter;
import com.place.interest.domain.Photo;
import com.place.interest.domain.Temple;
import com.place.interest.domain.TempleData;
import com.place.interest.domain.googlePlacesApi.GoogleNearBySearchResults;
import com.place.interest.domain.googlePlacesApi.GooglePlaceDetailsResult;
import com.place.interest.domain.googlePlacesApi.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class PlaceOfInterestService {

    public static final String COMMA = ",";
    private static final Logger logger = LoggerFactory.getLogger(PlaceOfInterestService.class);
    private static final String MESSAGE = "Name of the temple : %s " + System.lineSeparator() + " Latitude : %s " + System.lineSeparator() + " Longitude : %s";

    @Value("${application.nearby.search.url}")
    private String baseSearchUrl;

    @Value("${application.place.details.url}")
    private String basePlaceDetailsUrl;

    @Value("${application.place.photo.url}")
    private String basePlacePhotoUrl;

    @Value("${application.type}")
    private String type;

    @Value("${application.key}")
    private String key;

    @Autowired
    @Qualifier("googlePlacesAdapter")
    private PlacesAdapter googlePlacesAdapter;


    public TempleData fetchTemples(String lat, String lon, String radius){

        String url = buildSearchUrl(lat, lon, radius);
        logger.info(String.format("Url used to fetch temple data : %s", url));

        GoogleNearBySearchResults results = googlePlacesAdapter.fetchNearbySearchData(url);

        return getTempleData(results);
    }

    public TempleData fetchPlaceDetails(String placeId){
        String url = buildPlaceDetailsUrl(placeId);
        logger.info(String.format("Url used to fetch temple place details : %s", url));
        GooglePlaceDetailsResult googlePlaceDetailsResult = googlePlacesAdapter.fetchPlaceDetailsData(url);
        return getTempleData(googlePlaceDetailsResult);
    }


    public byte[] fetchPhoto(String photoReference) {
        String url = buildPlacePhotoUrl(photoReference);
        logger.info(String.format("Url used to fetch temple photo : %s", url));
        return googlePlacesAdapter.fetchPlacePhoto(url);
    }


    private TempleData getTempleData(GooglePlaceDetailsResult googlePlaceDetailsResult) {
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
            for (com.place.interest.domain.googlePlacesApi.Photo photo : resultPhotos){
                Photo returnPhoto = new Photo();
                returnPhoto.setHeight(photo.getHeight());
                returnPhoto.setWidth(photo.getWidth());
                returnPhoto.setReference(photo.getPhoto_reference());
                returnPhoto.setHtmlAttributions(photo.getHtml_attributions());
                photos.add(returnPhoto);
            }
        }
        temple.setPhotos(photos);
        temple.setPlaceId(result.getPlace_id());
        temple.setMapsUrl(result.getUrl());
        temple.setWebsite(result.getWebsite());
        List<Temple> temples = templeData.getTemples();
        temples.add(temple);
        return templeData;
    }


    private TempleData getTempleData(GoogleNearBySearchResults results) {

        List<Result> resultList = results.getResults();
        TempleData templeData = new TempleData();
        List<Temple> temples = templeData.getTemples();
        if (thisExists(resultList)) {
            for (Result result : resultList) {
                String name = result.getName();
                List<String> types = result.getTypes();
                if (isTypeAllowed(types, name.toLowerCase())) {
                    BigDecimal latitude = result.getGeometry().getLocation().getLat();
                    BigDecimal longitude = result.getGeometry().getLocation().getLng();
                    Temple temple = new Temple();
                    temple.setName(name);
                    temple.setLatitude(latitude);
                    temple.setLongitude(longitude);
                    temple.setPlaceId(result.getPlace_id());
                    logger.info(String.format(MESSAGE, name, latitude, longitude));
                    temples.add(temple);
                }
            }
        }
        return templeData;
    }

    private boolean isTypeAllowed(List<String> types, String name) {
        if(types.contains("hindu_temple")){
            return true;
        }

        if(name.contains("temple")){
            return true;
        }

        return false;
    }

    private boolean thisExists(List givenList) {
        return givenList != null;
    }

    private String buildSearchUrl(String lat, String lon, String radius) {
        StringBuilder builder = new StringBuilder(baseSearchUrl);
        builder.append(lat);
        builder.append(COMMA);
        builder.append(lon);
        builder.append("&radius=");
        builder.append(radius);
        builder.append("&types=");
        builder.append(type);
        return appendKey(builder);
    }

    private String buildPlaceDetailsUrl(String placeId) {
        StringBuilder builder = new StringBuilder(basePlaceDetailsUrl);
        builder.append(placeId);
        return appendKey(builder);
    }

    private String buildPlacePhotoUrl(String photoReference) {
        StringBuilder builder = new StringBuilder(basePlacePhotoUrl);
        builder.append(photoReference);
        return appendKey(builder);
    }

    private String appendKey(StringBuilder builder) {
        builder.append("&key=");
        builder.append(key);
        return builder.toString();
    }

}
