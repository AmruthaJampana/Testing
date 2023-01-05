package org.example.controller;

import org.example.entity.Person;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
   @Autowired
    private PersonService personService;
@GetMapping("/person")
    public List<Person> getByName(@RequestParam(value = "name", required = false) String name) {
    if (name != null) {
        return personService.findByName(name);
    }
    return personService.find();
}


    @PostMapping ("/person")
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }
    @PutMapping("/person/{id}")
    public Person put(@RequestBody Person person,@PathVariable("id") String id){
         return personService.put(person , id);
    }
    @GetMapping("/person/{id}")
    public Person findById(@PathVariable("id") String id){
          return personService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
           personService.deleteById(id);
    }

}
