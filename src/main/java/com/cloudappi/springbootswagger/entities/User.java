package com.cloudappi.springbootswagger.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", nullable=false)
	private Address address;
	
	public User() {
		
	}
	public User(int id, String name, String email, String birthDate, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}