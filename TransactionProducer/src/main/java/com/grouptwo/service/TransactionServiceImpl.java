package com.grouptwo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.entity.Transaction;
import com.grouptwo.persistence.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public Collection<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactionDao.getAllTransactions();
	}

	@Override
	public Transaction getTransById(int cardId) {
		// TODO Auto-generated method stub
		return transactionDao.getTransById(cardId);
	}

}
