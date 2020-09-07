package com.beecode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.beecode.util.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tb_product_comment")
@JsonIgnoreProperties
public class ProductComments extends AbstractEntity{

	@Column(name = "comment", nullable = false, length = 600)
	private String comment;
	
	@Column(name = "score", nullable = false)
	private int score;
	
	@Column(name = "dateTimeComment", nullable = false)
	private String dateTimeComment;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn
	@JsonBackReference(value = "product-comments-user")
	private User user;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	@JsonBackReference(value = "product-comments-product")
	private Product product;

	public ProductComments() {
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDateTimeComment() {
		return dateTimeComment;
	}

	public void setDateTimeComment(String dateTimeComment) {
		this.dateTimeComment = dateTimeComment;
	}

}
