package com.grouptwo.service;

import java.util.Collection;

import com.grouptwo.entity.Transaction;

public interface TransactionService {

public Collection<Transaction> getAllTransactions();
	
	public Transaction getTransById(int cardId);
}
