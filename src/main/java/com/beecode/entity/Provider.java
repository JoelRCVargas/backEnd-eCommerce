package com.beecode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.beecode.util.AbstractEntity;

@Entity(name = "tb_provider")
public class Provider extends AbstractEntity {

	@Column(name = "company_name", nullable = false, length = 100)
	private String company_name;

	@Column(name = "contact_first_name", nullable = true, length = 100)
	private String contact_first_name;

	@Column(name = "contact_last_name", nullable = true, length = 100)
	private String contact_last_name;

	@Column(name = "address1", nullable = false, length = 150)
	private String address1;

	@Column(name = "address2", nullable = true, length = 150)
	private String address2;

	@Column(name = "city", nullable = false, length = 120)
	private String city;

	@Column(name = "state", nullable = true, length = 150)
	private String state;

	@Column(name = "postal_code", nullable = true, length = 20)
	private String postal_code;

	@Column(name = "country", nullable = true, length = 150)
	private String country;

	@Column(name = "phone", nullable = true, length = 20)
	private String phone;

	@Column(name = "email", nullable = true, length = 120)
	private String email;

	@Column(name = "URL", nullable = true)
	private String URL;

	@Column(name = "payment_methods", nullable = true, length = 50)
	private String payment_methods;

	@Column(name = "note", nullable = true, length = 300)
	private String note;

	@Column(name = "logo_url", nullable = true)
	private String logo_url;

	@Column(name = "domain", nullable = true)
	private String domain;

	public Provider() {

	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getContact_first_name() {
		return contact_first_name;
	}

	public void setContact_first_name(String contact_first_name) {
		this.contact_first_name = contact_first_name;
	}

	public String getContact_last_name() {
		return contact_last_name;
	}

	public void setContact_last_name(String contact_last_name) {
		this.contact_last_name = contact_last_name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getPayment_methods() {
		return payment_methods;
	}

	public void setPayment_methods(String payment_methods) {
		this.payment_methods = payment_methods;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
