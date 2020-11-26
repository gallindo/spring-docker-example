package com.pismo.challenge.microservices.controller;

import com.pismo.challenge.microservices.dto.TransactionDto;
import com.pismo.challenge.microservices.dto.TransactionResultDto;
import com.pismo.challenge.microservices.dto.TransactionStatus;
import com.pismo.challenge.microservices.exception.TransactionAmountLimitException;
import com.pismo.challenge.microservices.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/transactions", produces = "application/json")
    public TransactionResultDto create(@RequestBody TransactionDto transactionDto) {

        try {
            TransactionResultDto transactionResultDto = transactionService.create(transactionDto);

            transactionResultDto.setTransactionStatus(

                    TransactionStatus.builder()
                            .success(true)
                            .message("Success")
                            .build()
            );

            return transactionResultDto;
        }catch(TransactionAmountLimitException e) {

            return TransactionResultDto.builder()
                    .amount(transactionDto.getAmount())
                    .accountId(transactionDto.getAccountId())
                    .operationTypeId(transactionDto.getOperationTypeId())
                    .transactionStatus(
                            TransactionStatus.builder()
                                    .success(false)
                                    .message(e.getMessage())
                                    .build()
                    )
                    .build();
        }


    }
}
