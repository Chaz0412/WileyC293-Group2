package com.grouptwo.GroupTwoMetroSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MetroUsers")
public class User {
	
	@Id
	int userId;
	String firstName;
	String lastName;
	String password;
	double salary;
}
