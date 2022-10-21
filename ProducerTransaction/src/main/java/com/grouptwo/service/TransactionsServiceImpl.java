package com.grouptwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.entity.Transactions;
import com.grouptwo.persistence.TransactionsDao;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsDao transactionsDao;

	@Override
	public List<Transactions> TransactionsByID(int id) {
		return transactionsDao.findBycardId(id);
	}

	

}
