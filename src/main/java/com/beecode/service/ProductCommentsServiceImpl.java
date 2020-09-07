package com.beecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.ProductComments;
import com.beecode.interfaces.ProductCommentsService;
import com.beecode.projection.ProductCommentsProjection;
import com.beecode.projection.ProductCommentsScoreProjection;
import com.beecode.repository.IProductCommentsRepository;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

	@Autowired
	private IProductCommentsRepository productCommentsRepo;

	@Override
	public ProductComments createProductComments(ProductComments productComments) {
		return this.productCommentsRepo.save(productComments);
	}

	@Override
	public List<ProductCommentsProjection> getAllProductCommentsbByProduct(Long id) {
		return this.productCommentsRepo.findAllByProductId(id);
	}

	@Override
	public List<ProductCommentsScoreProjection> getScoreProductCommentsByProduct(Long id) {
		return this.productCommentsRepo.findScoreByProductId(id);
	}

}
