package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.CategoryBusiness;
import com.sensors.dao.CategoryRepository;
import com.sensors.entities.Category;

@Service
public class CategoryImplementation implements CategoryBusiness {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void addCategory(Category category) {

		categoryRepository.save(category);

	}

	@Override
	public List<Category> getAllCategory() {

		return categoryRepository.findAll();
	}

	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public Category findCategoryById(Long categoryId) {

			return categoryRepository.findOne(categoryId);
		
	}

}
