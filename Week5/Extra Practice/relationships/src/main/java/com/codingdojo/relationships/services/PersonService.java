package com.codingdojo.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

public class PersonService {
	@Autowired
	private PersonRepository personRepo;
	
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}
	
	public Person createPerson(Person newPerson) {
		return personRepo.save(newPerson);
	}
	
	public Person findPerson(Long id) {
		return personRepo.findById(id).orElse(null);
	}
	
	public Person updatePerson(Person newPerson) {
		return personRepo.save(newPerson);
	}
	
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
}
