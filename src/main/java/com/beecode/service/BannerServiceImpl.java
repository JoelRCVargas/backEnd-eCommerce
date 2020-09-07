package com.beecode.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.Banner;
import com.beecode.interfaces.BannerService;
import com.beecode.projection.BannerProjection;
import com.beecode.repository.IBannerRepository;

@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	private IBannerRepository bannerRepo;
	
	@Override
	public Banner createBanner(Banner banner) {
		return this.bannerRepo.save(banner);
	}

	@Override
	public Banner updateBanner(Banner banner) {
		return this.bannerRepo.save(banner);
	}

	@Override
	public Optional<Banner> getBannerById(Long id) {
		Optional<Banner> optionalBanner = this.bannerRepo.findById(id);
		if(optionalBanner.isPresent()) {
			return optionalBanner;
		}	
		return null;
	}

	@Override
	public void deleteBanner(Long id) {
		this.bannerRepo.deleteById(id);
	}

	@Override
	public List<Banner> getAllBanner() {
		return this.bannerRepo.findAll();
	}

	@Override
	public Collection<BannerProjection> getAllProjetedBanner() {
		return this.bannerRepo.findAllProjetedBy();
	}

}
