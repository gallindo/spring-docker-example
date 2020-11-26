package com.pismo.challenge.microservices.dao;

import com.pismo.challenge.microservices.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {

}
