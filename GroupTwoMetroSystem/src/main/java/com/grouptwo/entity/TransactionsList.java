package com.grouptwo.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsList {
	
	Collection<Transactions> transactions;

}
