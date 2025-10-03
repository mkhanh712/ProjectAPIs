package com.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.entity.Category;
import com.main.service.CategoryService;

@RestController
@RequestMapping("/get/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
}
