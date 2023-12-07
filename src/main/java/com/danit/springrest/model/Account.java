package com.danit.springrest.model;

import com.danit.springrest.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.UUID;

import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of={"id"}, callSuper = true)
public class Account extends AbstractEntity {
    @Id
    private Long id;
    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Account(Currency currency, Customer customer) {
        this.number = generateAccountNumber();
        this.currency = currency;
        this.balance = 0.0;
        this.customer = customer;
    }
    private String generateAccountNumber() {
        return UUID.randomUUID().toString();
    }
}

