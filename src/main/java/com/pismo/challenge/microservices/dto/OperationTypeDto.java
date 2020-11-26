package com.pismo.challenge.microservices.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class OperationTypeDto {

    private String description;

    private Boolean debit;
}
