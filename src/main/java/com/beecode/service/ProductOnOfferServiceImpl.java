package com.beecode.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.ProductOnOffer;
import com.beecode.interfaces.ProductOnOfferService;
import com.beecode.projection.ProductOnOfferProjection;
import com.beecode.repository.IProductOnOfferRepository;

@Service
public class ProductOnOfferServiceImpl implements ProductOnOfferService{

	@Autowired
	private IProductOnOfferRepository productOnOfferRepo;
	
	@Override
	public ProductOnOffer createProductOnOffer(ProductOnOffer productOnOffer) {
		return this.productOnOfferRepo.save(productOnOffer);
	}

	@Override
	public ProductOnOffer updateProductOnOffer(ProductOnOffer productOnOffer) {
		return this.productOnOfferRepo.save(productOnOffer);
	}

	@Override
	public Optional<ProductOnOffer> getProductOnOfferById(Long id) {
		Optional<ProductOnOffer> optionalProductOnOffer = this.productOnOfferRepo.findById(id);
		if(optionalProductOnOffer.isPresent()) {
			return optionalProductOnOffer;
		}
		return null;
	}

	@Override
	public void deleteProductOnOffer(Long id) {
		this.productOnOfferRepo.deleteById(id);
	}

	@Override
	public List<ProductOnOffer> getAllProductOnOffer() {
		return this.productOnOfferRepo.findAll();
	}

	@Override
	public Collection<ProductOnOfferProjection> getAllProductOnOfferProjection() {
		return this.productOnOfferRepo.findAllBy();
	}
	
	

}
