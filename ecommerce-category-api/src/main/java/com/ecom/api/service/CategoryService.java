package com.ecom.api.service;

import java.util.List;
import java.util.Optional;

import com.ecom.api.model.Category;

public interface CategoryService {

	public Category save(Category category) ;
	
	public Optional<Category> getCategory(Long catId);
	
	public List<Category> getAllCategory();
	
	public void deleteCategory(Long catId);
	
	
}
