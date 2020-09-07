package com.beecode.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.beecode.entity.Product;
import com.beecode.interfaces.ProductService;
import com.beecode.projection.ProductCardProjection;
import com.beecode.projection.ProductProjection;
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

	@Override
	public Collection<ProductProjection> getCustomProducts() {
		return productRepo.findAllProjetedBy();
	}

	@Override
	public Slice<ProductProjection> getLikeCustomProductsByName(String name, Pageable pageable) {
		return productRepo.findByNameContaining(name,pageable);
	}

	@Override
	public Optional<Product> getBySku(String sku) {
		Optional<Product> optionalProduct = productRepo.findBySku(sku);
		if(optionalProduct.isPresent()) {
			return optionalProduct;
		}
		return null;
	}

	@Override
	public List<Product> getProductPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Product> pagedResult = this.productRepo.findAll(pageable);
		return pagedResult.toList();
	}

	@Override
	public Page<ProductCardProjection> getProductPage(Pageable pageable, int pageNo, int pageSize, List<String> type) {
		pageable = PageRequest.of(pageNo, pageSize);
		Page<ProductCardProjection> pageResult = this.productRepo.findProjetedDistinctByTypeNotIn(pageable,type);
		return pageResult;
	}

}
