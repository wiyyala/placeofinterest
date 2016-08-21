package com.place.interest.web.controller;

import com.place.interest.domain.TempleData;
import com.place.interest.service.PlaceOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TempleListController {

    private static final String LIST_URI = "<website>/templeList?lat=<latitude>&lon=<longitude>";
    private static final String INFO_URI = "<website>/templeInfo?placeId=<placeId>";
    private static final String PHOTO_URI = "<website>/templePhoto?photoReference=<photoReference>";

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

    @RequestMapping
    public List<String> templeApi(){
        return Arrays.asList(
                "TempleList Api : " + LIST_URI
                ,"TempleInfo Api : " + INFO_URI
                ,"TemplePhoto Api : " + PHOTO_URI
        );
    }

}
