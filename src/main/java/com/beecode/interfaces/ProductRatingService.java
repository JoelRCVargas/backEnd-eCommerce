package com.beecode.interfaces;

import java.util.List;

import com.beecode.entity.ProductRating;

public interface ProductRatingService {

	public ProductRating createProductRating(ProductRating productRating);
	public List<ProductRating> getAllProductRating();
	public List<ProductRating> getAllProductRatingByUserIdAndProductId(Long user_id, Long product_id);
	
}
