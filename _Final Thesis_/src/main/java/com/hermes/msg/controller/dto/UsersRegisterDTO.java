package com.hermes.msg.controller.dto;

public class UsersRegisterDTO {

	private Long id;
	private String username;
	private String name;
	private String last_name;
	private int identification_number;
	private String address;
	private String city;
	private String state;
	private String country;
	private int zip_code;
	private String password;

	public UsersRegisterDTO(Long id, String username, String name, String last_name, int identification_number, String address, String city, String state, String country, int zip_code, String password) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.last_name = last_name;
		this.identification_number = identification_number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip_code = zip_code;
		this.password = password;
	}

	public UsersRegisterDTO(String username, String name, String last_name, int identification_number, String address, String city, String state, String country, int zip_code, String password) {
		this.username = username;
		this.name = name;
		this.last_name = last_name;
		this.identification_number = identification_number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip_code = zip_code;
		this.password = password;
	}

	public UsersRegisterDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getIdentification_number() {
		return identification_number;
	}

	public void setIdentification_number(int identification_number) {
		this.identification_number = identification_number;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
