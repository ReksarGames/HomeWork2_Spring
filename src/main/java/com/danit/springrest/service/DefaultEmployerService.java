package com.danit.springrest.service;

import com.danit.springrest.dao.EmployerDao;
import com.danit.springrest.model.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultEmployerService implements EmployerService {
    private final EmployerDao employerDAO;

    public DefaultEmployerService(EmployerDao employerDAO) {
        this.employerDAO = employerDAO;
    }


    @Override
    public List<Employer> getAllEmployers() {
        return employerDAO.getAllEmployers();
    }

    @Override
    public Employer getEmployerById(Long id) {
        return employerDAO.getById(id);
    }

    @Override
    public void createEmployer(Employer newEmployer) {
        employerDAO.createEmployer(newEmployer);
    }

    @Override
    public void updateEmployer(Long id, Employer employer) {
        employerDAO.updateEmployer(id,employer);
    }

    @Override
    public void deleteEmployer(Long id) {
        employerDAO.deleteEmployer(id);
    }
}
