package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.beecode.util.AbstractEntity;

@Entity(name = "tb_category")
public class Category extends AbstractEntity {

	@Column(name = "category_name", nullable = false, length = 100)
	private String category_name;
	
	@Column(name = "description", nullable = true, length = 300)
	private String description;
	
	@Column(name = "status", nullable = false)
	private boolean status;

	public Category() {
		this.status = true;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
