package com.beecode.interfaces;

import java.util.List;

import com.beecode.entity.ProductComments;
import com.beecode.projection.ProductCommentsProjection;
import com.beecode.projection.ProductCommentsScoreProjection;

public interface ProductCommentsService {

	public ProductComments createProductComments(ProductComments productComments);
	public List<ProductCommentsProjection> getAllProductCommentsbByProduct(Long id);
	public List<ProductCommentsScoreProjection> getScoreProductCommentsByProduct(Long id);
}
