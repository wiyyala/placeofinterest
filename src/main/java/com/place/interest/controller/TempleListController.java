package com.place.interest.controller;

import com.place.interest.domain.TempleData;
import com.place.interest.service.PlaceOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempleListController {

    @Autowired
    private PlaceOfInterestService service;


    @RequestMapping(value = "/templeList")
    public TempleData templeList(@RequestParam String lat, @RequestParam String lon, @RequestParam(defaultValue = "5000") Integer radius){
        return service.fetchTemples(lat, lon, String.valueOf(radius));
    }

    @RequestMapping(value = "/templeInfo")
    public TempleData templePlaceInfo(@RequestParam String placeId){
        return service.fetchPlaceDetails(placeId);
    }

    @RequestMapping(value = "/templePhoto", produces = "image/jpg")
    public byte[]  templePhoto(@RequestParam String photoReference){
        return service.fetchPhoto(photoReference);
    }
}
