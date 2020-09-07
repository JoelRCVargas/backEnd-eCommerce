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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tb_product")
@JsonIgnoreProperties
public class Product extends AbstractEntity {

	public static final String HOT_TYPE = "HOT";
	public static final String NEW_TYPE = "NEW";
	public static final String NORMAL_TYPE = "NORMAL";

	@Column(name = "sku", nullable = false)
	private String sku;

	@Column(name = "name", nullable = false, length = 200)
	private String name;

	@Column(name = "description", nullable = false, length = 500)
	private String description;

	@Column(name = "unitPrice", nullable = false)
	private double unitPrice;

	@Column(name = "salePrice", nullable = false)
	private double salePrice;

	@Column(name = "MSRP", nullable = true)
	private double MSRP;

	@Column(name = "availableSize", nullable = true)
	private String availableSize;

	@Column(name = "availableColor", nullable = true)
	private String availableColor;

	@Column(name = "discount", nullable = true)
	private double discount;

	@Column(name = "statusDiscount", nullable = false)
	private boolean statusDiscount;

	@Column(name = "unit_weight", nullable = true, length = 15)
	private String unit_weight;

	@Column(name = "type", nullable = true, length = 15)
	private String type;

	@Column(name = "stock", nullable = false)
	private int stock;

	@Column(name = "IVA", nullable = false)
	private double IVA;

	@Column(name = "status", nullable = false)
	private boolean status;

	@Column(name = "note", nullable = true, length = 300)
	private String note;

	@Column(name = "picturePrincipal", nullable = false)
	private String picturePrincipal;

	@Column(name = "domain", nullable = false)
	private String domain;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductRating> productRating;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Product_picture> product_picture;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_provider")
	@JsonBackReference(value = "provider-product")
	private Provider provider;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_category	")
	@JsonBackReference(value = "category-product")
	private Category category;


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
		this.sku = UUID.randomUUID().toString();
		this.status = true;
		this.statusDiscount = false;
		this.discount = 0.0;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPicturePrincipal() {
		return picturePrincipal;
	}

	public void setPicturePrincipal(String picturePrincipal) {
		this.picturePrincipal = picturePrincipal;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getAvailableSize() {
		return availableSize;
	}

	public void setAvailableSize(String availableSize) {
		this.availableSize = availableSize;
	}

	public String getAvailableColor() {
		return availableColor;
	}

	public void setAvailableColor(String availableColor) {
		this.availableColor = availableColor;
	}

	public boolean isStatusDiscount() {
		return statusDiscount;
	}

	public void setStatusDiscount(boolean statusDiscount) {
		this.statusDiscount = statusDiscount;
	}

	public List<ProductRating> getProductRating() {
		return productRating;
	}

	public void setProductRating(List<ProductRating> productRating) {
		this.productRating = productRating;
	}

}
