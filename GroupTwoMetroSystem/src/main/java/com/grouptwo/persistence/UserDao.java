package com.grouptwo.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>  {
	
	@Transactional
	@Modifying
	@Query(value = "update metrousers set userBal = (:newBal) where userId = (:userId)", nativeQuery = true)
	public User updateBalance(@Param("userId") int userId, @Param("newBal") double userBal);
	
//	@Transactional
//	@Modifying
//	@Query(value = "insert into metrousers values(:fName,:sName,:pass,:bal)",nativeQuery = true)
//	public User insertUser(@Param("fName") String firstName,@Param("sName") String lastName, @Param("pass") String password,@Param("bal") double balance);
}
