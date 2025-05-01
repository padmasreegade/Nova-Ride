package com.example.novaride.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.novaride.entity.LocationData;

@Service
public class LocationService {
	
	@Autowired
	private LocationData latestLocation;

    @Scheduled(fixedRate = 30000)
    public LocationData getLatestLocation() throws IOException, InterruptedException {
    	String url = "http://10.0.0.142:8081";
    	HttpClient client  = HttpClient.newHttpClient();
    	HttpRequest request = HttpRequest.newBuilder()
    							.uri(URI.create(url))
    							.header("accept", "application/json")
    							.build();
    	HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    	
    	System.out.println("Polling for location at " + LocalDateTime.now());
    	
    	JSONObject json = new JSONObject(response.body());
    	double latitude = json.getDouble("latitude");
    	double longitude = json.getDouble("longitude");

    	latestLocation.setLatitude(latitude);
    	latestLocation.setLongitude(longitude);

    	return latestLocation;
    }
}
