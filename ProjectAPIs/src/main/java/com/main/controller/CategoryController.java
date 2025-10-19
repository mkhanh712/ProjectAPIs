package com.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.CategoryDTO;
import com.main.service.CategoryService;

@RestController
@RequestMapping("/api/public")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/get/categories")
	public List<CategoryDTO> getAllCategories(){
		return categoryService.getAllCategories();
	}
}
