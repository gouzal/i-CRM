package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.repository.PurchaseRepository;
import com.gouzal.icrm.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements Operation<Purchase>  {

	@Autowired
    PurchaseRepository purchaseRepository;

	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}
	
	public Optional<Purchase> findById(Long id) {
		return purchaseRepository.findById(id);
	}
	
	public void save(Purchase article) {
		purchaseRepository.save(article);
	}

	public void deleteById(Long id) {
		purchaseRepository.deleteById(id);
	}

	
	
}
