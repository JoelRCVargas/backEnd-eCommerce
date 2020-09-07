package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.beecode.util.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "tb_product_picture")
public class Product_picture extends AbstractEntity {

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "domain", nullable = false)
	private String domain;

	@Column(name = "tag", nullable = true, length = 50)
	private String tag;

	@JoinColumn(name = "id_product")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Product product;

	public Product_picture() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
