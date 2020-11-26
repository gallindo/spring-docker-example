package com.pismo.challenge.microservices.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
public class TransactionResultDto {

    private String id;

    private BigDecimal amount;

    private ZonedDateTime eventDate;

    private Long accountId;

    private Integer operationTypeId;

    private TransactionStatus transactionStatus;
}
