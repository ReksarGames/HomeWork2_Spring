package com.danit.springrest.service;

import com.danit.springrest.model.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getAllEmployers();
    Employer getEmployerById(Long id);
    void createEmployer(Employer newEmployer);
    void updateEmployer(Long id, Employer employer);
    void deleteEmployer(Long id);
}
