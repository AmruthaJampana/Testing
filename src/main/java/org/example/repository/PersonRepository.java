package org.example.repository;

import org.example.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,String > {

    List<Person> findAll();
    List<Person> findByName(String name);


}
