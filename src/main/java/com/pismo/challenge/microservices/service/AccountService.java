package com.pismo.challenge.microservices.service;

import com.pismo.challenge.microservices.dao.AccountDao;
import com.pismo.challenge.microservices.dao.OperationTypeDao;
import com.pismo.challenge.microservices.dao.TransactionDao;
import com.pismo.challenge.microservices.dto.AccountDto;
import com.pismo.challenge.microservices.dto.AccountResultDto;
import com.pismo.challenge.microservices.dto.TransactionDto;
import com.pismo.challenge.microservices.dto.TransactionResultDto;
import com.pismo.challenge.microservices.model.Account;
import com.pismo.challenge.microservices.model.OperationType;
import com.pismo.challenge.microservices.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public AccountResultDto create(AccountDto accountDto) {

        Account account = new Account(null, accountDto.getDocumentNumber());

        accountDao.save(account);

        return AccountResultDto.builder()
                .documentNumber(account.getDocumentNumber())
                .id(account.getId())
                .build();
    }

    public AccountResultDto find(Long id) {

        Optional<Account> accountOptional = accountDao.findById(id);

        if(!accountOptional.isPresent()) { return null; }

        Account account = accountOptional.get();

        return AccountResultDto.builder()
                .documentNumber(account.getDocumentNumber())
                .id(account.getId())
                .build();

    }
}
