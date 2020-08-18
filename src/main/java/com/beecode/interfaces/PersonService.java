package com.beecode.interfaces;

import java.util.List;

import com.beecode.entity.Person;

public interface PersonService {
	
	public Person createPerson(Person person);
	public Person updatePerson(Person person);
	public Person getPerson(Long personId);
	public void deletePerson(Long peronId);
	public List<Person> getAllPerson();

}
