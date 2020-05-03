package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.entity.City;
import com.gouzal.icrm.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements Operation<City> {

	@Autowired
    CityRepository cityRepository;

	public List<City> findAll() {
		return cityRepository.findAll();
		
	}
	
	public Optional<City> findById(Long id) {
		return cityRepository.findById(id);
		
	}
	
	public void save(City city) {
		cityRepository.save(city);

	}

	public void deleteById(Long idVille) {
		cityRepository.deleteById(idVille);
		
	}
	
}
