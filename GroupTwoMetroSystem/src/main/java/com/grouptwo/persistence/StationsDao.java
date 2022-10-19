package com.grouptwo.persistence;

import org.springframework.stereotype.Repository;

import com.grouptwo.entity.Stations;

@Repository
public interface StationsDao {
	
	public Stations getAllStations();
	
}
