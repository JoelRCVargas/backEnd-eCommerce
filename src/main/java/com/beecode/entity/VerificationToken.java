package com.beecode.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "tb_verification_token")
public class VerificationToken {

	public static final String STATUS_PENDING = "PENDING";
	public static final String STATUS_VERIFIED = "VERIFIED";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String token;
	private String status;
	private LocalDateTime expiredDateTime;
	private LocalDateTime issueDateTime;
	private LocalDateTime confirmedDateTime;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	public VerificationToken() {
		this.token = UUID.randomUUID().toString();
		this.issueDateTime = LocalDateTime.now();
		this.expiredDateTime = this.issueDateTime.plusDays(1);
		this.status = STATUS_PENDING;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getExpiredDateTime() {
		return expiredDateTime;
	}

	public void setExpiredDateTime(LocalDateTime expiredDateTime) {
		this.expiredDateTime = expiredDateTime;
	}

	public LocalDateTime getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public LocalDateTime getConfirmedDateTime() {
		return confirmedDateTime;
	}

	public void setConfirmedDateTime(LocalDateTime confirmedDateTime) {
		this.confirmedDateTime = confirmedDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
