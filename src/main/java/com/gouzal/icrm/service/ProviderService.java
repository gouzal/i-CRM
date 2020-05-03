package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.entity.Provider;
import com.gouzal.icrm.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService implements Operation<Provider> {

	@Autowired
    ProviderRepository providerRepository;

	public List<Provider> findAll() {
		return providerRepository.findAll();
	}
	
	public Optional<Provider> findById(Long id) {
		return providerRepository.findById(id);
	}
	
	public void save(Provider provider) {
		providerRepository.save(provider);
	}

	public void deleteById(Long id) {
		providerRepository.deleteById(id);
	}
	
}
