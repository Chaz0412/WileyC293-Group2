package com.grouptwo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="MetroUsers")
public class User {
	
	@Id
	private int userId;
	@Column(name = "userFName")
	private String firstName;
	@Column(name = "userSName")
	private String lastName;
	@Column(name = "userPass")
	private String password;
	@Column(name = "userBal")
	private double salary;
	public int getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public double getSalary() {
		return salary;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
