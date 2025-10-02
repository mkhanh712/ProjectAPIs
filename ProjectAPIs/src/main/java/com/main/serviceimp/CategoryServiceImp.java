package com.main.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.entity.Category;
import com.main.repository.CategoryRepository;
import com.main.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
