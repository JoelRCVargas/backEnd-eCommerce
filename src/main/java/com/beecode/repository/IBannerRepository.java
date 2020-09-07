package com.beecode.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.Banner;
import com.beecode.projection.BannerProjection;

public interface IBannerRepository extends JpaRepository<Banner, Long> {

	public Collection<BannerProjection> findAllProjetedBy();
}
