package com.beecode.interfaces;

import java.util.List;

import com.beecode.entity.Category;

public interface CategoryService {
	
	public Category createCategory(Category category);
	public Category updateCategory(Category category);
	public Category getCategoryById(Long id);
	public void deleteCategory(Long id);
	public List<Category> getAllCategory();

}
