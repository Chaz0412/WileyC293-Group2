package com.grouptwo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.grouptwo.entity.Station;

public interface StationService {
	
	public Collection<Station> getAllStations();
	
	public Station getStationById(int stationId);
	
}
