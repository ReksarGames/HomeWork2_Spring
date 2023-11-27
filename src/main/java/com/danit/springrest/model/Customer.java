package com.danit.springrest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Setter
@Getter
public class Customer extends AbstractEntity {

    @Id
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age", nullable = false)
    private int age;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public Customer(String name, String email, int age) {
        this.id = getId();
        this.name = name;
        this.email = email;
        this.age = age;
    }

}
