package com.place.interest.adapters.impl;

import com.place.interest.adapters.PlacesAdapter;
import com.place.interest.domain.googlePlacesApi.GoogleNearBySearchResults;
import com.place.interest.domain.googlePlacesApi.GooglePlaceDetailsResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("googlePlacesAdapter")
public class GooglePlacesAdapter implements PlacesAdapter {

    public static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Override
    public GoogleNearBySearchResults fetchNearbySearchData(String url) {
        return getRestTemplate().getForObject(url, GoogleNearBySearchResults.class);
    }

    @Override
    public GooglePlaceDetailsResult fetchPlaceDetailsData(String url) {
        return getRestTemplate().getForObject(url, GooglePlaceDetailsResult.class);
    }

    @Override
    public byte[] fetchPlacePhoto(String url) {
        return getRestTemplate().getForObject(url, byte[].class);
    }

    private RestTemplate getRestTemplate() {
        return REST_TEMPLATE;
    }
}
