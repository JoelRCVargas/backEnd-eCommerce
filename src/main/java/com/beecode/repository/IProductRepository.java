package com.beecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

}
