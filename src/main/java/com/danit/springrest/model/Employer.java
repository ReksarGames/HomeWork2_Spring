package com.danit.springrest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "employers")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
public class Employer extends AbstractEntity {

    @Id
    @Column(name = "employer_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Employer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
