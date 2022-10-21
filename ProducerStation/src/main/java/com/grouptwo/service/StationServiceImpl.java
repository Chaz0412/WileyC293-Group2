package com.grouptwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.entity.StationList;
import com.grouptwo.persistence.StationDao;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationDao stationDao;

	

	@Override
	public StationList AllStations() {
		
		return new StationList(stationDao.findAll());
	}

}
