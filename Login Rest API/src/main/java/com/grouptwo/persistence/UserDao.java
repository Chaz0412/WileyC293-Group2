package com.grouptwo.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public User getUserByUserIdAndPassword(int UserID,String password);
	
	@Transactional
	@Modifying
	@Query(value = "insert into metrousers(userFName,userSName,userPass,userBal) "
			+ "values(:fname,:lname, :pass,:bal)",nativeQuery = true)
	public int insertUser(@Param("fname")String fname, @Param("lname") 
		String lname, @Param("pass") String password, @Param("bal") double bal);
	
	@Transactional
	@Modifying
	@Query(value = "update metrousers set userBal = (:newBal) where userId = (:userId)", nativeQuery = true)
	public int updateBalance(@Param("userId") int userId, @Param("newBal") double userBal);
	
}
