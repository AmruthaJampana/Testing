package org.example.controller;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> get(){
        return employeeService.find();
    }
    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }
    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return employeeService.getById(id);

    }

    @PutMapping("/employee/{id}")
    public Employee put(@RequestBody Employee employee,@PathVariable("id") Long id ){
       return employeeService.put(employee, id);
    }
    @DeleteMapping("employee/{id}")
    public void deleteById(@PathVariable("id") long id){
        employeeService.deleteById(id);
    }
}
