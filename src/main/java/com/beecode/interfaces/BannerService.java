package com.beecode.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.beecode.entity.Banner;
import com.beecode.projection.BannerProjection;

public interface BannerService {

	public Banner createBanner(Banner banner);
	public Banner updateBanner(Banner banner);
	public Optional<Banner> getBannerById(Long id);
	public void deleteBanner(Long id);
	public List<Banner> getAllBanner();
	public Collection<BannerProjection> getAllProjetedBanner();
}
