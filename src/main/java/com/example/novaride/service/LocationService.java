package com.example.novaride.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.novaride.entity.LocationData;

@Service
public class LocationService {

	private final WebClient webClient;
	private final String locationApiUrl;
	private final LocationData latestLocation;

	public LocationService(WebClient webClient, @Value("${location.source.url}") String locationApiUrl,
			LocationData latestLocation) {
		this.webClient = webClient;
		this.locationApiUrl = locationApiUrl;
		this.latestLocation = latestLocation;
	}

	@Scheduled(fixedRate = 30000)
	public LocationData getLatestLocation() {
		LocationData location = webClient.get().uri(locationApiUrl).retrieve().bodyToMono(LocationData.class).block();
		if (location != null) {
			latestLocation.setLatitude(location.getLatitude());
			latestLocation.setLongitude(location.getLongitude());
		}
		System.out.println("Polled using WebClient at " + LocalDateTime.now());
		return latestLocation;
	}
}
