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

@Data
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
}
