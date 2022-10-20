package com.grouptwo.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.entity.Station;
import com.grouptwo.service.StationService;

@RestController
public class StationResource {
	
	@Autowired
	private StationService stationService;
	
	@GetMapping(path = "/getAllStations", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Station> getAllStationResource() {
		return stationService.getAllStations();
	}
	
	@GetMapping(path = "/getStation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Station getStationByIdResource(@PathVariable("id") int stationId) {
		return stationService.getStationById(stationId);
	}
	
}
