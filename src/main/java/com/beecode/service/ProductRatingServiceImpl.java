package com.beecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.ProductRating;
import com.beecode.interfaces.ProductRatingService;
import com.beecode.repository.IProductRatingRepository;

@Service
public class ProductRatingServiceImpl implements ProductRatingService {

	@Autowired
	private IProductRatingRepository productRatingRepo;
	
	@Override
	public ProductRating createProductRating(ProductRating productRating) {
		Long userId = productRating.getUser().getId();
		Long productId = productRating.getProduct().getId();
		//System.out.println("userId : "+ userId + "productId :"+productId);
		List<ProductRating> getProductRatingByUserId = 
				productRatingRepo.findByUserIdAndProductId(userId, productId);
		if(!getProductRatingByUserId.isEmpty()) {
			productRating.setId(getProductRatingByUserId.get(0).getId());
		}
		
		return productRatingRepo.save(productRating);
	}

	@Override
	public List<ProductRating> getAllProductRating() {
		return productRatingRepo.findAll();
	}

	@Override
	public List<ProductRating> getAllProductRatingByUserIdAndProductId(Long user_id, Long product_id) {
		return this.productRatingRepo.findByUserIdAndProductId(user_id, product_id);
	}

}
