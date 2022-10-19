package com.grouptwo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metrostations")
public class Stations {
	
	@Id
	private int stationId;
	@Column(name = "stationName")
	private String stationName;
}
