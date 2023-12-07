package com.danit.springrest.service;

import com.danit.springrest.dao.EmployerRepository;
import com.danit.springrest.model.Employer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultEmployerService implements EmployerService {
    private final EmployerRepository employerRepository;

    public DefaultEmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    @Override
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    @Override
    public Employer getEmployerById(Long id) {
        return employerRepository.findById(id).orElse(null);
    }

    @Override
    public void createEmployer(Employer newEmployer) {
        employerRepository.save(newEmployer);
    }

    @Override
    public void updateEmployer(Long id, Employer updatedEmployer) {
        Employer existingEmployer = employerRepository.findById(id).orElse(null);
        if (existingEmployer != null) {
            existingEmployer.setName(updatedEmployer.getName());
            existingEmployer.setAddress(updatedEmployer.getAddress());
            employerRepository.save(existingEmployer);
        } else {
            throw new IllegalArgumentException("Employer not found with ID: " + id);
        }
    }

    @Override
    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }

    @Override
    public void createEmployerManual(String employerName, String employerAddress) {
        employerRepository.save(new Employer(employerName, employerAddress));
    }
}
