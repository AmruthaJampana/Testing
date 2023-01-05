package org.example.service;

import org.example.entity.Employee;
import org.example.entity.Person;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
   @Autowired
    private PersonRepository personRepository;

   public List<Person> find(){

       return personRepository.findAll();
   }


    public List<Person> findByName(String name){
        return personRepository.findByName(name);
    }

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person put(Person person , String id) {
        Optional<Person> existingOptional = personRepository.findById(id);
        if (existingOptional.isPresent()) {
            Person existingPerson = existingOptional.get();
            existingPerson.setName(person.getName());
            existingPerson.setAge(person.getAge());
            return personRepository.save(existingPerson);
        }
        return null;
    }

// testing

        public Person getById(String id ) {

            Optional<Person> existingPerson = personRepository.findById(id);
            if (existingPerson.isPresent()) {
                return existingPerson.get();

            }
            return null;
        }

        public void deleteById(String id){

            personRepository.deleteById(id);
        }



        }

