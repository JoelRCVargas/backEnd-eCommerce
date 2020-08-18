package com.beecode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.Category;
import com.beecode.interfaces.CategoryService;
import com.beecode.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ICategoryRepository categoryRepo;
	
	@Override
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

}
