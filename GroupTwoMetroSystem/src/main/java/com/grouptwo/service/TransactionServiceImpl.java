package com.grouptwo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.Transactions;
import com.grouptwo.entity.TransactionsList;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Collection<Transactions> getAllTransactions() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(
				"http://localhost:8084/getAllTransactions", 
				TransactionsList.class).getTransactions();
	}

	@Override
	public Collection<Transactions> getTransById(int cardId) {
		try {
			TransactionsList transactionList = restTemplate.getForObject(
					"http://localhost:8084/trans/" + cardId, 
					TransactionsList.class);
			return transactionList.getTransactions();
		} catch (Exception e) {
			System.out.println("Errorrrrrrrr");
			e.printStackTrace();
			return null;
		}
	}

}
