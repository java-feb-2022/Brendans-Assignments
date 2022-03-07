package com.codingdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
	public Dojo findDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	public Dojo updateDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
