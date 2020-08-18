package com.beecode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.Product;
import com.beecode.interfaces.ProductService;
import com.beecode.repository.IProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private IProductRepository productRepo;

	@Override
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public Optional<Product> getUserBySku(String SKU) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

}
