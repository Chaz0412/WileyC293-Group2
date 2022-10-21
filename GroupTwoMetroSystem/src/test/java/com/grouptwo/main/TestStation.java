package com.grouptwo.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.Station;
import com.grouptwo.entity.StationList;

@SpringBootTest
class TestStation {
	
	
	@Autowired
	RestTemplate rest;
	
	@Test
	void testAllStations() {
		Collection<Station> tempStations = rest.getForObject("http://localhost:8086/station",StationList.class).getStations(); 
		assertEquals(tempStations.size(), 5, "Length of collection must be 5 because there's only 5 stations!");
	}

}
