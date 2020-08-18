package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.beecode.util.AbstractEntity;

@Entity(name = "tb_top_notice")
public class TopNotice extends AbstractEntity {

	@Column(name = "description", nullable = false, length = 50)
	private String description;

	@Column(name = "status", nullable = false)
	private boolean status;

	public String getDescription() {
		return description;
	}

	public TopNotice() {

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
