package com.grouptwo.persistence;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.Station;

@Repository
public interface StationDao extends JpaRepository<Station, Integer> {
	

	@Query(value = "select * from metrostations")
	public Collection<Station> getAllStations();
	
	@Query(value = "select * from metrostations where stationId = (:id)")
	public Station getStationById(@Param("id") int stationId);
	
}
