package com.beecode.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import com.beecode.util.AbstractEntity;
import com.beecode.util.PasswordEncoder;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "tb_user")
public class User extends AbstractEntity{
	
	@Column(unique = true)
	private Email email;
	
	@Embedded
	@Column(length = 50)
	private PasswordEncoder password;
	
	@Column(name = "status", nullable = true)
	@ColumnDefault("1")
	private boolean status;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Person person;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonBackReference
    private VerificationToken verificationToken;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"),
				foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Set<Role> roles;
	
	
	public User() {}

	public String getEmail() {
		return email.getValue();
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getPassword() {
		return password.getValue();
	}

	public void setPassword(PasswordEncoder password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public VerificationToken getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(VerificationToken verificationToken) {
		this.verificationToken = verificationToken;
	}
}
