package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.beecode.util.AbstractEntity;

@Entity(name = "tb_role")
public class Role extends AbstractEntity {

	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";
	
	@Column(name = "role_name", unique = true)
	private String roleName;
	
	@Column(name = "description", length = 50)
	private String description;
	
	private boolean status;

	public Role() {
	}

	public Role(String roleName, String description, boolean status) {
		this.roleName = roleName;
		this.description = description;
		this.status = status;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
