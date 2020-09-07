package com.beecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.ProductRating;

public interface IProductRatingRepository extends JpaRepository<ProductRating, Long>{
	
	public List<ProductRating> findByUserIdAndProductId(Long user_id, Long product_id); 

}
