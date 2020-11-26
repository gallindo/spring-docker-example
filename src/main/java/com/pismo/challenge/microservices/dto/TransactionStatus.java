package com.pismo.challenge.microservices.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionStatus {

    private Boolean success;

    private String message;
}
