package com.danit.springrest.service;

import com.danit.springrest.model.Customer;
import com.danit.springrest.model.Employer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface EmployerService {
    List<Employer> getAllEmployers();
    Page<Employer> getAllEmployers(PageRequest pageRequest);
    Employer getEmployerById(Long id);
    void createEmployer(Employer newEmployer);
    void updateEmployer(Long id, Employer employer);
    void deleteEmployer(Long id);
    void createEmployerManual(String employeeName, String employeeAddress);
}
