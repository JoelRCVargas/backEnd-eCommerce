package com.beecode.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.beecode.entity.ProductOnOffer;
import com.beecode.projection.ProductOnOfferProjection;

public interface ProductOnOfferService {

	public ProductOnOffer createProductOnOffer(ProductOnOffer productOnOffer);
	public ProductOnOffer updateProductOnOffer(ProductOnOffer productOnOffer);
	public Optional<ProductOnOffer> getProductOnOfferById(Long id);
	public void deleteProductOnOffer(Long id);
	public List<ProductOnOffer> getAllProductOnOffer();
	public Collection<ProductOnOfferProjection> getAllProductOnOfferProjection();
	
}
