package com.ajay.pulseBackend.dao;

import java.util.List;

import com.ajay.pulseBackend.model.Product;


public interface ProductDao {

	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> listProduct();
	public Product getProductById(int prodId);
	//public List<Product> listProductByCat(int catId);
	
}
