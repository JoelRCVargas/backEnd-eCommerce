package com.beecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.Provider;

public interface IProviderRepository extends JpaRepository<Provider, Long> {

}
