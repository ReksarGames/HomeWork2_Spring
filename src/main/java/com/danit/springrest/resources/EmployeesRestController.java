package com.danit.springrest.resources;

import com.danit.springrest.dao.DefaultEmployeeDao;
import com.danit.springrest.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeesRestController {
    private final DefaultEmployeeDao defaultEmployeeDao;

    public EmployeesRestController(DefaultEmployeeDao defaultEmployeeDao){
        this.defaultEmployeeDao = defaultEmployeeDao;
    }
    private List<Employee> employees = Arrays.asList(
      new Employee("John", 2L),
      new Employee("Steve", 2L),
      new Employee("Greg", 3L),
      new Employee("Helen", 4L)
    );
    @GetMapping
    public List<Employee> findAll(){
        return defaultEmployeeDao.findAll();
    }
    @GetMapping("/id")
    public ResponseEntity<?> findById(@RequestParam("id") String id){
        Optional<Employee> employee = defaultEmployeeDao.findById(Long.parseLong(id));
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("add")
    public String add(@RequestParam("name") String name, @RequestParam("id") String id, Model model){
        defaultEmployeeDao.add(name, Long.parseLong(id));
        System.out.println("Name: " + name + "\nId: " + id);
        model.addAttribute("message", "Employee added successfully");
        return "Employee added successfully " +"Name: " + name + " id " +id;
    }
    @GetMapping("delete")
    public String delete(@RequestParam("id") String id){
        defaultEmployeeDao.deleteById(Long.parseLong(id));
        System.out.println("Employee was deleted");
        return "Employee was deleted " + "id: " +id;
    }
}
