package com.pismo.challenge.microservices.service;

import com.pismo.challenge.microservices.dao.OperationTypeDao;
import com.pismo.challenge.microservices.dto.OperationTypeDto;
import com.pismo.challenge.microservices.dto.OperationTypeResultDto;
import com.pismo.challenge.microservices.dto.TransactionDto;
import com.pismo.challenge.microservices.model.OperationType;
import com.pismo.challenge.microservices.model.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OperationTypeService {

    @Autowired
    private OperationTypeDao operationTypeDao;

    public OperationTypeResultDto create(OperationTypeDto operationTypeDto) {

        OperationType operationType = OperationType.builder()
                .debit(operationTypeDto.getDebit())
                .description(operationTypeDto.getDescription())
                .build();

        operationTypeDao.save(operationType);

        return OperationTypeResultDto.builder()
                .debit(operationType.getDebit())
                .description(operationType.getDescription())
                .id(operationType.getId())
                .build();
    }

    public List<OperationTypeResultDto> findAll(Long id) {

        List<OperationType> operationTypes = operationTypeDao.findAll();

        return operationTypes.stream()
                .map(operationType -> OperationTypeResultDto.builder()
                        .debit(operationType.getDebit())
                        .description(operationType.getDescription())
                        .id(operationType.getId())
                        .build())
                .collect(Collectors.toList());
    }
}
