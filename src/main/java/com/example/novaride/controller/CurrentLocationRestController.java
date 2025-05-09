package com.example.novaride.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novaride.entity.LocationData;
import com.example.novaride.service.LocationService;

@RestController
public class CurrentLocationRestController {
	@Autowired
	private LocationService locationService;

	@GetMapping("/location")
	public LocationData getLatestLocation() throws IOException, InterruptedException {
		return locationService.getLatestLocation();
	}
}
