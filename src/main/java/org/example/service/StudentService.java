package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student create(Student student){
        return studentRepository.save(student);
    }

    public Student put(Student student, Long id){
        Optional<Student> existingOptional = studentRepository.findById(id);
        if (existingOptional.isPresent()) {
            Student existingStudent = existingOptional.get();
            existingStudent.setAge(student.getAge());
            existingStudent.setName(student.getName());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public Student getById(long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return studentRepository.findById(id).get();
        }
        return null;
    }

    public void delete(Long id){

        studentRepository.deleteById(id);

    }





        }




