package com.beecode.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "tb_forgot_password")
public class ForgotPassword {

	public static final String STATUS_NO_USED = "WITHOUT_USING";
	public static final String STATUS_USED = "USED";
	public static final String LINK_DEVELOPERS = "http://localhost:4200/user/usernamerecovery/";
	
	public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
	public static final String SUCCESSFULLY = "SUCCESSFULLY";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String token;
	private String status;
	private LocalDateTime expiredDateTime;
	private LocalDateTime issueDateTime;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_user")
	private User user;
	
	public ForgotPassword() {
		this.token = UUID.randomUUID().toString();
		this.issueDateTime = LocalDateTime.now();
		this.expiredDateTime = this.issueDateTime.plusDays(1);
		this.status = STATUS_NO_USED;
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


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}