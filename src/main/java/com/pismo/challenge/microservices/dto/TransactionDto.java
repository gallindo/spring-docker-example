package com.pismo.challenge.microservices.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransactionDto {

    private Long accountId;
    private Integer operationTypeId;
    private BigDecimal amount;
}
