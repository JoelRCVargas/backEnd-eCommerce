package com.beecode.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.ProductOnOffer;
import com.beecode.projection.ProductOnOfferProjection;

public interface IProductOnOfferRepository extends JpaRepository<ProductOnOffer, Long> {
	
	public Collection<ProductOnOfferProjection> findAllBy();
	
}
