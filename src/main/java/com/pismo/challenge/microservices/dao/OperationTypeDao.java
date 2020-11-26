package com.pismo.challenge.microservices.dao;

import com.pismo.challenge.microservices.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeDao extends JpaRepository<OperationType, Integer> {

}
