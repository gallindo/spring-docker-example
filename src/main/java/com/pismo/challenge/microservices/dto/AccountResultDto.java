package com.pismo.challenge.microservices.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountResultDto {

    private Long id;

    private String documentNumber;

    private BigDecimal availableCreditLimit;

}
