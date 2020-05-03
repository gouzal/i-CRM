package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gouzal.icrm.repository.ProductRepository;

@Service
public class ProductService implements Operation<Product> {

	@Autowired 
	@Qualifier("productRepository")
    ProductRepository productRepository;


	public List<Product> findAll() {
		return productRepository.findAll();
		
	}
	
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
		
	}
	
	public void save(Product product) {
		productRepository.save(product);

	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
		
	}

	
	
}
