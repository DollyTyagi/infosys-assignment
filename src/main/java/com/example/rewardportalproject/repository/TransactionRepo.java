package com.example.rewardportalproject.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rewardportalproject.entities.Transactions;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {
	
	  List<Transactions> findByTransactionDateAfter(LocalDate date);

}
