package com.beecode.interfaces;

import java.util.List;
import java.util.Optional;

import com.beecode.entity.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public Product getProductById(Long id);
	public void deleteProduct(Long id);
	public Optional<Product> getUserBySku(String SKU);
	public List<Product> getAllProduct();
	
}
