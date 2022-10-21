package com.grouptwo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;
import java.time.format.DateTimeFormatter;  


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MetroTrans")
public class Transaction {

	@Id
	int transId;
    int cardId;
    int startStation;
    int destStation;
    Date swipeInTime;
    Date swipeOutTime;
}
