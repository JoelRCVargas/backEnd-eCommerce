package com.beecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
