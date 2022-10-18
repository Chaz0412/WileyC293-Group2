package com.grouptwo.persistence;

import org.springframework.stereotype.Repository;

import com.grouptwo.entity.User;

@Repository
public interface UserDao {
	public User addFunds(int userId);
	public User removeFunds(int userId, int deduction);
}
