package com.grouptwo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.Station;

@Repository
public interface StationDao extends JpaRepository<Station, Integer> {
	
}
