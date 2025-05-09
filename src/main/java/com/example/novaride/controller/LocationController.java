package com.example.novaride.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.novaride.entity.Checkpoint;
import com.example.novaride.entity.LocationData;
import com.example.novaride.service.LocationService;
import com.example.novaride.utilities.CheckpointConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private CheckpointConfig checkpointConfig;

	@GetMapping("/map")
	public String showMap(Model model) throws IOException, InterruptedException {
		LocationData locationData = locationService.getLatestLocation();
		model.addAttribute("latitude", locationData.getLatitude());
		model.addAttribute("longitude", locationData.getLongitude());
		List<Checkpoint> checkpoints = checkpointConfig.getCheckpoints();
		model.addAttribute("checkpoints", new ObjectMapper().writeValueAsString(checkpoints));
		return "map";
	}
}
