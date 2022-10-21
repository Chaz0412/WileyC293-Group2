package com.grouptwo.service;

import java.util.Collection;

import com.grouptwo.entity.Transactions;

public interface TransactionService {

public Collection<Transactions> getAllTransactions();
	
	public Collection<Transactions> getTransById(int cardId);
}
