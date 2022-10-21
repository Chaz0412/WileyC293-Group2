package com.grouptwo.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.lang.Math.*;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.entity.Transactions;
import com.grouptwo.persistence.TransactionsDao;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsDao transactionsDao;

	@Override
	public List<Transactions> TransactionsByID(int id) {
		return transactionsDao.findBycardId(id);
	}

	@Override
	public boolean AddTransaction(int id, int startStation, int destStation) {
		try {
			Date date = new Date();
			java.sql.Timestamp  startTime = new Timestamp(date.getTime());
			Date dateDest = new Date();
			java.sql.Timestamp  destTime = new Timestamp(dateDest.getTime());
			double fees = Math.abs(startStation - destStation)*5;
			int rows = transactionsDao.insertTransaction(id, startStation, destStation, startTime, destTime, fees);
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

}
