package com.codingdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	public Ninja findNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
	public Ninja updateNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
