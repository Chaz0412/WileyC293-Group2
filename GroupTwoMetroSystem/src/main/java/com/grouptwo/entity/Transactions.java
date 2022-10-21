package com.grouptwo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MetroTrans")
public class Transactions {

	@Id
	private int transId;
	private int cardId;
	private int startStation;
	private int destStation;
	private java.sql.Timestamp swipeInTime;
	private java.sql.Timestamp swipeOutTime;
	private double fee;
}
