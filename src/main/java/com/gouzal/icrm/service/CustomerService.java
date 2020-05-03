package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gouzal.icrm.repository.CustomerRepository;


@Service
public class CustomerService implements Operation<Customer> {

	@Autowired
    CustomerRepository customerRepository;


	public List<Customer> findAll() {
		return customerRepository.findAll();
		
	}
	
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
		
	}
	
	public void save(Customer customer) {
		customerRepository.save(customer);

	}

	public void deleteById(Long id) {
		customerRepository.deleteById(id);
		
	}
	
}
