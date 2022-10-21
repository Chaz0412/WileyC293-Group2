package com.grouptwo.entity;

import java.util.Collection;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StationList {
	
	Collection<Station> stations;
	
	
}
