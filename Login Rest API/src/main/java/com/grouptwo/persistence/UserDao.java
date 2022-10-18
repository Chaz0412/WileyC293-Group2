package com.grouptwo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public User getUserByUserIdAndPassword(int UserID,String password);
	
}
