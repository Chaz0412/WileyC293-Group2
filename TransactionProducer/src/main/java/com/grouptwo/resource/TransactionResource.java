package com.grouptwo.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.entity.Transaction;
import com.grouptwo.service.TransactionService;

@RestController
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(path = "/getAllTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Transaction> getAllStationResource() {
		return transactionService.getAllTransactions();
	}
	
	@GetMapping(path = "/getTrans/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction getStationByIdResource(@PathVariable("id") int cardId) {
		return transactionService.getTransById(cardId);
	}
}
