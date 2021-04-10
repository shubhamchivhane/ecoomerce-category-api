package com.ecom.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.exception.CategoryNotFoundException;
import com.ecom.api.model.Category;
import com.ecom.api.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	final static org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	CategoryRepository repo;
	
	@Override
	public Category save(Category category) {
		
		return repo.save(category);
	}

	@Override
	public Optional<Category> getCategory(Long catId) {
		logger.info("service method getCategory :"+catId);
		Optional<Category> opt= repo.findById(catId);
		if(!opt.isPresent())
		{
			throw new CategoryNotFoundException("Category not found with id {} "+ catId);
		}
		return null;
	}

	@Override
	public void deleteCategory(Long catId) {
		repo.deleteById(catId);

	}

	@Override
	public List<Category> getAllCategory() {
		
		return repo.findAll();
	}

}
