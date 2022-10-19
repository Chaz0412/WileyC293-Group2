package com.grouptwo.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.User;

@Repository
public interface UserDao {
	public User addFunds(int userId);
	public User removeFunds(int userId, int deduction);
	
	@Transactional
	@Modifying
	@Query(value = "insert into employees values(:fName,:sName,:pass,:bal)",nativeQuery = true)
	public User insertEmployee(@Param("fName") String firstName,@Param("sName") String lastName, @Param("pass") String password,@Param("bal") double balance);
}
