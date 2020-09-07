package com.beecode.projection;

import java.util.List;

public interface ProductCardProjection {
	
	Long getId();
	String getSku();
	String getType();
	boolean getStatusDiscount();
	double getDiscount();
	String getDomain();
	String getPicturePrincipal();
	String getName();
	List<ProductRatingProjection> getProductRating();
	CategoryProjection getCategory();
	//int sProjectionRatingScore();
	double getSalePrice();
	
}
