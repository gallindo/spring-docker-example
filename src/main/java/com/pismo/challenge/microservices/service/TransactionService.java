package com.pismo.challenge.microservices.service;

import com.pismo.challenge.microservices.dao.OperationTypeDao;
import com.pismo.challenge.microservices.dao.TransactionDao;
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
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private OperationTypeDao operationTypeDao;

    private Map<Integer, OperationType> operationTypes;

    @PostConstruct
    public void loadOperationTypes() {

        operationTypes = operationTypeDao.findAll().stream()
                .collect(Collectors.toMap(OperationType::getId, operationType -> operationType));
    }

    public TransactionResultDto create(TransactionDto transactionDto) {

        OperationType operationType = operationTypes.get(transactionDto.getOperationTypeId());

        Transaction transaction = Transaction.builder()
                .account(new Account(transactionDto.getAccountId()))
                .operationType(operationType)
                .amount(getAmount(transactionDto, operationType))
                .eventDate(ZonedDateTime.now(ZoneId.of(ZoneOffset.UTC.getId())))
                .build();

        transactionDao.save(transaction);

        return TransactionResultDto.builder()
                .accountId(transactionDto.getAccountId())
                .amount(transaction.getAmount())
                .eventDate(transaction.getEventDate())
                .id(transaction.getId().toString())
                .operationTypeId(transactionDto.getOperationTypeId())
                .build();
    }

    private BigDecimal getAmount(TransactionDto transactionDto, OperationType operationType) {

        if (operationType.getDebit()) { return transactionDto.getAmount().negate(); }

        return transactionDto.getAmount();
    }
}
