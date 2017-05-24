package com.sensors.business;

import java.util.List;

import com.sensors.entities.Category;

public interface CategoryBusiness {

	
	public void addCategory(Category category);
	public List<Category> getAllCategory();
	public void deleteCategory(Category category);
	public void updateCategory(Category category);
	public Category findCategoryById(Long categoryId);
	
}
