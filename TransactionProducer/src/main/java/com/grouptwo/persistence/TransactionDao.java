package com.grouptwo.persistence;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.Transaction;


@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

	@Query(value = "select * from metrotrans")
	public Collection<Transaction> getAllTransactions();
	
	@Query(value = "select * from metrotrans where cardId = (:id)")
	public Transaction getTransById(@Param("id") int cardId);
}
