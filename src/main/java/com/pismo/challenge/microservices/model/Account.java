package com.pismo.challenge.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    public Account(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;
}
