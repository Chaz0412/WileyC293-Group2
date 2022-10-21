package com.grouptwo.persistence;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.Transactions;

@Repository
public interface TransactionsDao extends JpaRepository<Transactions, Integer> {
	
	public List<Transactions> findBycardId(int cardID);
	
	@Transactional
	@Modifying
	@Query(value = "insert into metrotrans(cardId,startStation,destStation,swipeInTime, swipeOutTime, fee) "
			+ "values(:id,:start, :dest,:inTime, :outTime, :fee)",nativeQuery = true)
	public int insertTransaction(@Param("id") int id,@Param("start") int startStation, @Param("dest")int destStation, @Param("inTime") Timestamp startTime,@Param("outTime") Timestamp destTime,
			@Param("fee") double fees);
}
