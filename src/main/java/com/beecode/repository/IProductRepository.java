package com.beecode.repository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.beecode.entity.Product;
import com.beecode.projection.ProductCardProjection;
import com.beecode.projection.ProductProjection;

public interface IProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long>{

	public Collection<ProductProjection> findAllProjetedBy();
	
	public Slice<ProductProjection> findByNameContaining(String name,Pageable pageable);
	
	public Optional<Product> findBySku(String sku);
	
	//public Page<ProductCardProjection> findAllProjetedBy(Pageable pageable);
	
	public Page<ProductCardProjection> findProjetedDistinctByTypeNotIn(Pageable pageable, List<String> types);
}
