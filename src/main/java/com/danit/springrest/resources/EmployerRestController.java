package com.danit.springrest.resources;

import com.danit.springrest.model.Employer;
import com.danit.springrest.service.EmployerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employers")
public class EmployerRestController {

    private final EmployerService employerService;

    @Autowired
    public EmployerRestController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public ResponseEntity<Void> createEmployer(@RequestBody Employer newEmployer) {
        employerService.createEmployer(newEmployer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Другие методы контроллера
}
