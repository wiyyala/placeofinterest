package com.place.interest.adapters;

import com.place.interest.domain.googlePlacesApi.GoogleNearBySearchResults;
import com.place.interest.domain.googlePlacesApi.GooglePlaceDetailsResult;

public interface PlacesAdapter {
    GoogleNearBySearchResults fetchNearbySearchData(String url);
    GooglePlaceDetailsResult fetchPlaceDetailsData(String url);

    byte[] fetchPlacePhoto(String url);
}
