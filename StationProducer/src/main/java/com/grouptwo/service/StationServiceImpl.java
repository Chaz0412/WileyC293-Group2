package com.grouptwo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.entity.Station;
import com.grouptwo.persistence.StationDao;


@Service
public class StationServiceImpl implements StationService {
	
	@Autowired
	StationDao stationDao;
	
	@Override
	public Collection<Station> getAllStations() {
		// TODO Auto-generated method stub
		return stationDao.getAllStations();
	}

	@Override
	public Station getStationById(int stationId) {
		// TODO Auto-generated method stub
		return stationDao.getStationById(stationId);
	}

}
