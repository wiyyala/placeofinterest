package com.place.interest.service;

import com.place.interest.adapters.PlacesAdapter;
import com.place.interest.domain.TempleData;
import com.place.interest.domain.googlePlacesApi.GoogleNameSearchResult;
import com.place.interest.domain.googlePlacesApi.GoogleNearBySearchResults;
import com.place.interest.domain.googlePlacesApi.GooglePlaceDetailsResult;
import com.place.interest.service.converters.GoogleResultConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PlaceOfInterestService {

    public static final String COMMA = ",";
    private static final Logger logger = LoggerFactory.getLogger(PlaceOfInterestService.class);
    private static final List<String> TEMPLE_STRINGS = Arrays.asList("temple", "mandir");


    @Value("${application.nearby.search.url}")
    private String baseSearchUrl;

    @Value("${application.place.details.url}")
    private String basePlaceDetailsUrl;

    @Value("${application.place.photo.url}")
    private String basePlacePhotoUrl;

    @Value("${application.place.prediction.url}")
    private String basePlacePredictionUrl;

    @Value("${application.place.prediction.component.url}")
    private String basePlacePredictionComponentUrl;

    @Value("${application.type}")
    private String type;

    @Autowired
    @Qualifier("googlePlacesAdapter")
    private PlacesAdapter googlePlacesAdapter;

    @Autowired
    @Qualifier("googleResultConverter")
    private GoogleResultConverter googleResultConverter;


    public TempleData fetchTemples(String lat, String lon, String radius){

        String url = buildSearchUrl(lat, lon, radius);
        logger.info(String.format("Url used to fetch temple data : %s", url));

        GoogleNearBySearchResults results = googlePlacesAdapter.fetchNearbySearchData(url);

        return googleResultConverter.getTempleData(results);
    }

    public TempleData fetchPlaceDetails(String placeId){
        String url = buildPlaceDetailsUrl(placeId);
        logger.info(String.format("Url used to fetch temple place details : %s", url));
        GooglePlaceDetailsResult googlePlaceDetailsResult = googlePlacesAdapter.fetchPlaceDetailsData(url);
        return googleResultConverter.getTempleData(googlePlaceDetailsResult);
    }


    public byte[] fetchPhoto(String photoReference) {
        String url = buildPlacePhotoUrl(photoReference);
        logger.info(String.format("Url used to fetch temple photo : %s", url));
        return googlePlacesAdapter.fetchPlacePhoto(url);
    }

    public TempleData fetchPredictions(String hint, String country) {
        TempleData templeData = new TempleData();
        TEMPLE_STRINGS
                .stream()
                .forEach(s -> {
                    String url = buildPredictionsUrl(hint + "+" + s, country);
                    logger.info(String.format("Url used to fetch temple predictions : %s", url));
                    GoogleNameSearchResult result = googlePlacesAdapter.fetchPredictions(url);
                    googleResultConverter.getTempleData(result, templeData);
                });

        return templeData;
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

    private String buildPredictionsUrl(String hint, String country) {
        StringBuilder builder = new StringBuilder(basePlacePredictionUrl);
        builder.append(hint);
        builder.append(country);
        return appendKey(builder);
    }

    private String appendKey(StringBuilder builder) {
        builder.append("&key=");
        builder.append(System.getenv("API_KEY"));
        return builder.toString();
    }

}
