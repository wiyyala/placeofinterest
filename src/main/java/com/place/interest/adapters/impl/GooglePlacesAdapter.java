package com.place.interest.adapters.impl;

import com.place.interest.adapters.PlacesAdapter;
import com.place.interest.domain.googlePlacesApi.GoogleNameSearchResult;
import com.place.interest.domain.googlePlacesApi.GoogleNearBySearchResults;
import com.place.interest.domain.googlePlacesApi.GooglePlaceDetailsResult;
import com.place.interest.exceptions.GenericException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component("googlePlacesAdapter")
public class GooglePlacesAdapter implements PlacesAdapter {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Override
    public GoogleNearBySearchResults fetchNearbySearchData(String url) {
        try {
            return getRestTemplate().getForObject(url, GoogleNearBySearchResults.class);
        } catch (HttpClientErrorException e) {
            throw new GenericException(e.getStatusCode().value(), e.getStatusCode().getReasonPhrase());
        }
    }

    @Override
    public GooglePlaceDetailsResult fetchPlaceDetailsData(String url) {
        try {
            return getRestTemplate().getForObject(url, GooglePlaceDetailsResult.class);
        } catch (HttpClientErrorException e) {
            throw new GenericException(e.getStatusCode().value(), e.getStatusCode().getReasonPhrase());
        }
    }

    @Override
    public byte[] fetchPlacePhoto(String url) {
        try {
            return getRestTemplate().getForObject(url, byte[].class);
        } catch (HttpClientErrorException e) {
            throw new GenericException(e.getStatusCode().value(), e.getStatusCode().getReasonPhrase());
        }
    }

    @Override
    public GoogleNameSearchResult fetchPredictions(String url) {
        try {
            return getRestTemplate().getForObject(url, GoogleNameSearchResult.class);
        } catch (HttpClientErrorException e) {
            throw new GenericException(e.getStatusCode().value(), e.getStatusCode().getReasonPhrase());
        }
    }

    private RestTemplate getRestTemplate() {
        return REST_TEMPLATE;
    }
}
