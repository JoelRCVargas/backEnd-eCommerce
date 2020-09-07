package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.beecode.util.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tb_product_on_offer")
public class ProductOnOffer extends AbstractEntity {

	@Column(name = "domain", nullable = false)
	private String domain;

	@Column(name = "urlImage", nullable = false)
	private String urlImage;
	
	@Column(name = "description", nullable = true, length = 150)
	private String description;

	@Column(name = "status", nullable = false)
	private boolean status;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Product product;

	public ProductOnOffer() {
	}

	public ProductOnOffer(String domain, String urlImage,String description, boolean status, Product product) {
		this.domain = domain;
		this.urlImage = urlImage;
		this.status = status;
		this.product = product;
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
