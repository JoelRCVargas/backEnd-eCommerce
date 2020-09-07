package com.beecode.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.beecode.entity.Product;
import com.beecode.projection.ProductCardProjection;
import com.beecode.projection.ProductProjection;

public interface ProductService {
	
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public Product getProductById(Long id);
	public void deleteProduct(Long id);
	public Optional<Product> getUserBySku(String SKU);
	public List<Product> getAllProduct();
	public Collection<ProductProjection> getCustomProducts();
	public Slice<ProductProjection> getLikeCustomProductsByName(String name, Pageable pageable);
	public Optional<Product> getBySku(String sku);
	public List<Product> getProductPaginated(int pageNo, int pageSize);
	public Page<ProductCardProjection> getProductPage(Pageable pageable, int pageNo, int pageSize, List<String> type);

}
