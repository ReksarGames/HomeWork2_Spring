package com.danit.springrest.dao;


import com.danit.springrest.model.Employer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DefaultEmployerDao implements EmployerDao {
    List<Employer> employers = new ArrayList<Employer>();
    @Override
    public List<Employer> getAllEmployers() {
        return employers;
    }

    @Override
    public Employer getEmployerById(Long id) {
        return getById(id);
    }

    @Override
    public void createEmployer(Employer employer) {
        employers.add(employer);
    }

    @Override
    public void updateEmployer(Long id, Employer employerUpdated) {
        Employer existingEmploy = getById(employerUpdated.getId());

        if (existingEmploy != null){
            existingEmploy.setName(employerUpdated.getName());
            existingEmploy.setAddress(employerUpdated.getAddress());
        }
    }

    @Override
    public void deleteEmployer(Long id) {
        employers.removeIf(account -> account.getId().equals(id));
    }

    @Override
    public Employer getById(Long accountId) {
        return employers.stream()
                .filter(account -> account.getId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createEmployerManual(String employeeName, String employeeAddress) {
        employers.add(new Employer(employeeName, employeeAddress));
    }
}
