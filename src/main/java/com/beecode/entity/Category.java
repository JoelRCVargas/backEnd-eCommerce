package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.beecode.util.AbstractEntity;

@Entity(name = "tb_category")
public class Category extends AbstractEntity {

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description", nullable = true, length = 300)
	private String description;

	@Column(name = "status", nullable = false)
	private boolean status;

	public Category() {
		this.status = true;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
