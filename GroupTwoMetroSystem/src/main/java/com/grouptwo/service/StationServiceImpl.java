package com.grouptwo.service;

import java.util.Collection;
import java.util.List;

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
		try {
			System.out.println("Helloo PEople");
			StationList stationNames = restTemplate.getForObject(
					"http://localhost:8084/station",
					StationList.class);
			System.out.println(stationNames.toString());
			return stationNames.getStations();
		} catch (Exception e) {
			System.out.println("i am here for some reason?!?");
			e.printStackTrace();
			return null;
		}
	
		
	
	}

//	@Override
//	public Station getStationById(int stationId) {
//		return restTemplate.getForObject("http://localhost:8083/getStation/"+stationId, Station.class);
//	}
	
	
}
