package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student")
    public List<Student> getByName(@RequestParam(value = "name", required = false) String name){
        if(name != null) {
            return studentService.findByName(name);
        }
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable("id") long id){
        return studentService.getById(id);

    }

    @PostMapping("/student")
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping("/student/{id}")
    public Student put(@RequestBody Student student, @PathVariable("id") long id){
        return studentService.put(student, id);
    }


    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable("id") long id){
        studentService.delete(id);
    }
}
