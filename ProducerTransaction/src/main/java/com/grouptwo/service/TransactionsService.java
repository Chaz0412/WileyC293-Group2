package com.grouptwo.service;


import java.util.List;

import com.grouptwo.entity.Transactions;

public interface TransactionsService {
	
	public List<Transactions> TransactionsByID(int id);

	public boolean AddTransaction(int id, int startStation, int destStation);
	

}
