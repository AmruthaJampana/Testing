package org.example.service;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> find(){
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee){
        return employeeRepository.insert(employee);
    }

    public Employee getById(Long id){
        Optional<Employee> optionalEmployee  = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        return null;

    }

    public Employee put(Employee employee, Long id){
        Optional<Employee> existingOptional = employeeRepository.findById(id);
        if(existingOptional.isPresent()){
           Employee existingEmployee = existingOptional.get();
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setName(employee.getName());
            return employeeRepository.save(existingEmployee);
        }
        return null;

    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
}
