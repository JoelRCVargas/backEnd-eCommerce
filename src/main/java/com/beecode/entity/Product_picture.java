package com.beecode.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.beecode.util.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "tb_product_picture")
public class Product_picture extends AbstractEntity{
	
	@Column(name = "picture", nullable = false)
	private Blob picture;
	
	@Column(name = "tag", nullable = true, length = 50)
	private String tag;
	
	@JoinColumn(name = "id_product")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Product product;
	
	public Product_picture() {
	
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
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
