package com.pismo.challenge.microservices.dao;

import com.pismo.challenge.microservices.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
