package com.pismo.challenge.microservices.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationTypeResultDto {

    private Integer id;

    private String description;

    private Boolean debit;
}
