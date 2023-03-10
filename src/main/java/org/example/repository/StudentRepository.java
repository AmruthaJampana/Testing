package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    List<Student> findAll();
    List<Student> findByName(String name);
}
