package com.grouptwo.GroupTwoMetroSystem.persistence;

import org.springframework.stereotype.Repository;

import com.grouptwo.GroupTwoMetroSystem.entity.User;

@Repository
public interface UserDao {
	public User getUserByIdAndPassword(int userId, String password);
}
