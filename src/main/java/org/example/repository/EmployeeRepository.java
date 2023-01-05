package org.example.repository;

import org.example.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    List<Employee> findAll();

    List<Employee> findByName(String name);
}
