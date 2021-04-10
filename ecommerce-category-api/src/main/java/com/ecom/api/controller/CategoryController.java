package com.ecom.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.model.Category;
import com.ecom.api.service.CategoryService;

@RestController
public class CategoryController {
	
	static
	{
		System.out.println("controller ------");
	}

	Logger logger = LoggerFactory.getLogger("CategoryController");

	CategoryService CategoryService;

	public CategoryController(CategoryService CategoryService) {
		this.CategoryService = CategoryService;
	}

	@PostMapping("/category")
	@ResponseBody
	public Category createCategory(@RequestBody Category Category) {
		Category CategorySaved = CategoryService.save(Category);

		logger.info("Category Saved :" + CategorySaved.toString());
		return Category;
	}

	@GetMapping("/category/{id}")
	public Category get(@PathVariable("id") Long id) {

		Optional<Category> CategoryRetreived = CategoryService.getCategory(id);
		Category Category = CategoryRetreived.get();
		return Category;
	}

//	@GetMapping("solcommerce/pdp-service/Category/bypage")
//	Page<Category> getCategorysByPage(
//			@RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
//			@RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
//		return CategoryService.getCategoryByPage(pageNumber, pageSize);
//	}

	@PutMapping("/category/{id}")
	@ResponseBody
	public Category updateCategory(@RequestBody Category Category) {
		Category CategoryUpdated = CategoryService.save(Category);

		logger.info("Category Saved :" + CategoryUpdated.toString());
		return Category;
	}

	/*---Delete a Category by id---*/
	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		CategoryService.deleteCategory(id);
		return ResponseEntity.ok().body("Category has been deleted successfully.");
	}
	
	@GetMapping("/category")
	public List<Category> getAllCategory()
	{
		System.out.println("This is category++++++++++++++++");
		List<Category> catgories=CategoryService.getAllCategory();
		return catgories;
	}
}
