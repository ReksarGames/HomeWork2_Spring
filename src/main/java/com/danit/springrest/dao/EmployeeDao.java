package com.danit.springrest.dao;

import com.danit.springrest.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> findAll();
    Optional findById(Long id);
    void add(String name, Long id);
    Optional deleteById(Long id);

}
