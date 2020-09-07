package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.beecode.util.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tb_banner")
public class Banner extends AbstractEntity {

	@Column(name = "bannerUrl", nullable = false)
	private String bannerUrl;

	@Column(name = "domain", nullable = false)
	private String domain;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "subtitle", nullable = false)
	private String subtitle;

	@Column(name = "description", nullable = true)
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Product product;

	public Banner() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
