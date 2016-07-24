package com.place.interest.controller;

import com.place.interest.domain.TempleData;
import com.place.interest.service.PlaceOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempleNameSearchController {

    @Autowired
    private PlaceOfInterestService service;

    @RequestMapping(value = "/byName")
    public TempleData getPredictions(@RequestParam String hint, @RequestParam(defaultValue = "IN") String country){
        return service.fetchPredictions(hint, country);
    }

}
