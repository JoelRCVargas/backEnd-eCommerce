package com.beecode.projection;

public interface ProductOnOfferProjection {
	
	String getDomain();
	String getUrlImage();
	String getDescription();
	ProductProjection getProduct();
	
	public interface ProductProjection {
		boolean getStatusDiscount();
		double getDiscount();
		String getName();
		String getPicturePrincipal();
		String getSku();
	}
}
