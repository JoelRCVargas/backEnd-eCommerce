package com.beecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.ProductComments;
import com.beecode.projection.ProductCommentsProjection;
import com.beecode.projection.ProductCommentsScoreProjection;

public interface IProductCommentsRepository extends JpaRepository<ProductComments, Long> {

	public List<ProductCommentsProjection> findAllByProductId(Long id);
	
	public List<ProductCommentsScoreProjection> findScoreByProductId(Long id);
	
}
