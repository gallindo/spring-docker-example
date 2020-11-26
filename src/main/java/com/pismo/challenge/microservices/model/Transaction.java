package com.pismo.challenge.microservices.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "TRANSACTIONS")
@GenericGenerator(name = "UUID_generator", strategy = "uuid2")
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID_generator")
    @Column(name = "UUID", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "EVENT_DATE")
    private ZonedDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "OPERATION_TYPE_ID", referencedColumnName = "ID")
    private OperationType operationType;



}

