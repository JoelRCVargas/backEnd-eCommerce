package com.beecode.entity;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.util.Assert;

@Embeddable
public class Email {
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

	@Column(name = "email", unique = true)
	private String value;

	public Email(String emailAddress) {
		Assert.isTrue(isValid(emailAddress), "Invalid email address!");
		this.value = emailAddress;
	}

	protected Email() {

	}
	
	public static boolean isValid(String candidate) {
		return candidate == null ? false : PATTERN.matcher(candidate).matches();
	}

	@Override
	public String toString() {
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
