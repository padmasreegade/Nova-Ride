package com.example.novaride.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.novaride.entity.LocationData;
import com.example.novaride.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
    private LocationService locationService;

    @GetMapping("/location")
    public LocationData getLatestLocation() throws IOException, InterruptedException {
    	return locationService.getLatestLocation();
    }
    
    @GetMapping("/map")
    public String showMap(Model model) throws IOException, InterruptedException {
    	LocationData locationData = locationService.getLatestLocation();
        model.addAttribute("latitude", locationData.getLatitude());
        model.addAttribute("longitude", locationData.getLongitude());
        return "map";
    }}
