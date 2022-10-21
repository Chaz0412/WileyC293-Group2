package com.grouptwo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.Transactions;

@Repository
public interface TransactionsDao extends JpaRepository<Transactions, Integer> {
	
	public List<Transactions> findBycardId(int cardID);
}
