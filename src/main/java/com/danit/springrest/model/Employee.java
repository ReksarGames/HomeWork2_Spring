package com.danit.springrest.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Employee {
    private String name;
    @Getter
    private Long id;
    public Employee(String name, Long id){
        this.name = name;this.id = id;
    }
}
