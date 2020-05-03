package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.repository.CategoryRepository;
import com.gouzal.icrm.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements Operation<Category> {

	@Autowired
    CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
	public void save(Category category) {
		categoryRepository.save(category);
	}

	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
		
	}
}
