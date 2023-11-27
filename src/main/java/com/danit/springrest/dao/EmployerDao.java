package com.danit.springrest.dao;

import com.danit.springrest.model.Employer;

import java.util.List;

public interface EmployerDao {
     List<Employer> getAllEmployers();
     Employer getEmployerById(Long id);
     void createEmployer(Employer employer);
     void updateEmployer(Long id, Employer employer);
     void deleteEmployer(Long id);
     Employer getById(Long accountId);
     void createEmployerManual(String employeeName, String employeeAddress);
}
