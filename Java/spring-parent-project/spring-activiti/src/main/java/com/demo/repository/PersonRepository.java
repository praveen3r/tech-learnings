package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUsername(String username);

}
