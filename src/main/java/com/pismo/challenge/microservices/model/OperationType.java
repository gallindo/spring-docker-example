package com.pismo.challenge.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "OPERATION_TYPE")
public class OperationType {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_DEBIT")
    private Boolean debit;
}
