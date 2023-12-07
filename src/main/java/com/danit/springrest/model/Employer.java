package com.danit.springrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "employers")
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = {"customers"})
@EqualsAndHashCode(of={"id"}, callSuper = true)
public class Employer extends AbstractEntity {
    @JsonIgnore
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<Customer> customers;
    @Id
    private Long id;

    public Employer(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
