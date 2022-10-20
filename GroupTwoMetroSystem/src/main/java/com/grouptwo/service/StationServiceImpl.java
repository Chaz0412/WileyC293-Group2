package com.grouptwo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.Station;
import com.grouptwo.entity.StationList;

@Service
public class StationServiceImpl implements StationService{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Collection<Station> getAllStations() {
		return restTemplate.getForObject("http://localhost:8083/getAllStations", StationList.class).getStationList();
		
	
	}

	@Override
	public Station getStationById(int stationId) {
		return restTemplate.getForObject("http://localhost:8083/getStation/"+stationId, Station.class);
	}
	
	
}
