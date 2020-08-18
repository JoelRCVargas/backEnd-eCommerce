package com.beecode.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.beecode.util.AbstractEntity;

@Entity(name = "tb_product")
public class Product extends AbstractEntity {
	
	@Column(name = "SKU", nullable = false)
	private String SKU;
	
	@Column(name = "product_name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "product_description", nullable = false, length = 250)
	private String description;
	
	@Column(name = "unit_price", nullable = false)
	private double unit_price;
	
	@Column(name = "sale_price", nullable = false)
	private double sale_price;
	
	@Column(name = "MSRP", nullable = true)
	private double MSRP;
	
	@Column(name = "available_size", nullable = true)
	private String available_size;
	
	@Column(name = "available_color", nullable = true)
	private String available_color;
	
	@Column(name = "discount", nullable = true)
	private double discount;
	
	@Column(name = "status_discount", nullable = false)
	private boolean status_discount;
	
	@Column(name = "unit_weight", nullable = true, length = 15)
	private String unit_weight;
	
	@Column(name = "stock", nullable = false)
	private int stock;
	
	@Column(name = "IVA", nullable = false)
	private double IVA;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "ranking", nullable = true)
	private double ranking;
	
	@Column(name = "note", nullable = true, length = 300)
	private String note;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Product_picture> product_picture;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_provider")
	private Provider provider;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_category	")
	private Category category;
	
	public String getAvailable_size() {
		return available_size;
	}

	public void setAvailable_size(String available_size) {
		this.available_size = available_size;
	}

	public String getAvailable_color() {
		return available_color;
	}

	public void setAvailable_color(String available_color) {
		this.available_color = available_color;
	}

	public double getIVA() {
		return IVA;
	}

	public void setIVA(double iVA) {
		IVA = iVA;
	}

	public List<Product_picture> getProduct_picture() {
		return product_picture;
	}

	public void setProduct_picture(List<Product_picture> product_picture) {
		this.product_picture = product_picture;
	}

	public Product() {
		this.SKU = UUID.randomUUID().toString();
		this.status = true;
		this.status_discount = false;
		this.discount = 0.0;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public double getSale_price() {
		return sale_price;
	}

	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}

	public double getMSRP() {
		return MSRP;
	}

	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isStatus_discount() {
		return status_discount;
	}

	public void setStatus_discount(boolean status_discount) {
		this.status_discount = status_discount;
	}

	public String getUnit_weight() {
		return unit_weight;
	}

	public void setUnit_weight(String unit_weight) {
		this.unit_weight = unit_weight;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getRanking() {
		return ranking;
	}

	public void setRanking(double ranking) {
		this.ranking = ranking;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
