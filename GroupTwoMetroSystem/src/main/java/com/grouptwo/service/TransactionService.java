package com.grouptwo.service;

import java.util.Collection;

import com.grouptwo.entity.Transactions;
import com.grouptwo.entity.User;

public interface TransactionService {

public Collection<Transactions> getAllTransactions();
	
	public Collection<Transactions> getTransById(int cardId);
	
	public Boolean addTransaction(int id, String start, String end);
}
