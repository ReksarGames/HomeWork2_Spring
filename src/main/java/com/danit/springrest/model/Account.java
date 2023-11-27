package com.danit.springrest.model;

import com.danit.springrest.enums.Currency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.UUID;

import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
public class Account extends AbstractEntity {

    @Id
    @Column(name = "account_id")
    private Long id;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    public Account(Currency currency, Customer customer) {
        this.id = generateUniqueId();
        this.number = generateAccountNumber();
        this.currency = currency;
        this.balance = 0.0;
        this.customer = customer;
    }
    public Account(){}
    private Long generateUniqueId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    private String generateAccountNumber() {
        return UUID.randomUUID().toString();
    }
}

