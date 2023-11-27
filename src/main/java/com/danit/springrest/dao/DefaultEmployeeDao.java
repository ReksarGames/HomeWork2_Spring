package com.danit.springrest.dao;

import com.danit.springrest.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultEmployeeDao implements EmployeeDao{
    @Override
    public String toString() {
        return "DefaultEmployeeDao{" +
                "employees=" + employees +
                '}';
    }

    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    @Override
    public void add(String name, Long id) {
        employees.add(new Employee(name, id));
    }

    @Override
    public Optional<Employee> deleteById(Long id) {
        Optional<Employee> deletedEmployee = findById(id);
        employees.removeIf(employee -> employee.getId().equals(id));
        return deletedEmployee;
    }
}
