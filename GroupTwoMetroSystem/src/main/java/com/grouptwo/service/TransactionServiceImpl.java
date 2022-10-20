package com.grouptwo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.Transaction;
import com.grouptwo.entity.TransactionList;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	RestTemplate restTemplate;
	
	
	
	@Override
	public Collection<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://localhost:8084/getAllTransactions", TransactionList.class).getTransactionList();
	}

	@Override
	public Transaction getTransById(int cardId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://localhost:8084/getTrans/" + cardId, Transaction.class);
	}

}
