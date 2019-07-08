package com.ajay.pulseBackend.dao;

import java.util.List;

import com.ajay.pulseBackend.model.Category;

public interface CategoryDao {

	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> listCategory();
	public Category getCategoryById(int catId);
	
	
}
