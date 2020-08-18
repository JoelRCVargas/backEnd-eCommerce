package com.beecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Long> {

}
