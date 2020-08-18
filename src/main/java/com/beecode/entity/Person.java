package com.beecode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.beecode.util.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity(name = "tb_person")
public class Person extends AbstractEntity {

	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 50, nullable = false)
	private String lastName;

	@Column(name = "address", length = 200, nullable = true)
	private String address;

	@Column(name = "city", length = 200, nullable = true)
	private String city;

	@Column(name = "phone", length = 25, nullable = true)
	private String phone;

	@Column(name = "age", nullable = true)
	private int age;

	@Column(name = "sex", length = 15, nullable = true)
	private String sex;

	/** Emmbed Class USER **/
	@Transient
	@JsonUnwrapped
	private String email;

	@Transient
	@JsonUnwrapped
	private String password;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	@JsonBackReference
	private User user;

	public Person() {
	}

	public Person(String firstName, String lastName, String address, String city, String phone, int age, String sex,
			String email, String password, User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.password = password;
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/** Emmbed Class USER **/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
