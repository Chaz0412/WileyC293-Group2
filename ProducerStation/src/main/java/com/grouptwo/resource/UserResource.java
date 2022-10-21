package com.grouptwo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.entity.StationList;
import com.grouptwo.service.StationService;

@RestController
public class UserResource {

	@Autowired
	private StationService stationService;
	
	@GetMapping(path = "/station",produces = MediaType.APPLICATION_JSON_VALUE)
	public StationList loginResource() {
		return stationService.AllStations();
	}
}
