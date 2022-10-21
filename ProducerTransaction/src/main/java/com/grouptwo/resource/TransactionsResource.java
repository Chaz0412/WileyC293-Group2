package com.grouptwo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.entity.TransactionsList;
import com.grouptwo.service.TransactionsService;

@RestController
public class TransactionsResource {

	@Autowired
	private TransactionsService transactionsService;
	
	@GetMapping(path = "/trans/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public TransactionsList loginResource(@PathVariable("id") int id) {
		return new TransactionsList(transactionsService.TransactionsByID(id));
				
	}
	
	@GetMapping(path = "/addTrans/{id}/{start}/{dest}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean balanceResource(@PathVariable("id") int cardId ,@PathVariable("start") int startStation, @PathVariable("dest") int destStation) {

		return transactionsService.AddTransaction(cardId, startStation, destStation);
	}
}
