package com.grouptwo.GroupTwoMetroSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MetroUsers")
public class User {
	
	@Id
	@Getter
	@Setter
	private int userId;
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private double salary;
}
