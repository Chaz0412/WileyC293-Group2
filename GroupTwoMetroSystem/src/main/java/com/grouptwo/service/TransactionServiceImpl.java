package com.grouptwo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.Transactions;
import com.grouptwo.entity.TransactionsList;

@Service
public class TransactionServiceImpl implements TransactionService {

	private int id1;
	private int id2;
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
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

	@Override
	public Boolean addTransaction(int id, String start, String end) {
		if (start.equals("London"))
        {
            id1 = 1;
        } else if(start.equals("Birmingham")) {
            id1 = 2;
        } else if(start.equals("Sheffield")) {
            id1 = 3;
        } else if(start.equals("Newcastle")) {
            id1 = 4;
        } else if(start.equals("Edinburgh")) {
            id1 = 5;
        }

        if (end.equals("London"))
        {
            id2 = 1;
        } else if(end.equals("Birmingham")) {
            id2 = 2;
        } else if(end.equals("Sheffield")) {
            id2 = 3;
        } else if(end.equals("Newcastle")) {
            id2 = 4;
        } else if(end.equals("Edinburgh")) {
            id2 = 5;
        }
        
        try {
        	
        	
        	boolean bool = restTemplate.getForEntity(
					"http://localhost:8084/addTrans/" + id
					+ "/" +id1+"/"+id2, 
					Boolean.class).getBody();
        	
        	double fees = (Math.abs(id1 - id2)*5) *-1 ;
        	userService.changeBalance(id, fees);
        	
			return bool;
		} catch (Exception e) {
			System.out.println("Errorrrrrrrr");
			e.printStackTrace();
			return null;
		}
	}

}
