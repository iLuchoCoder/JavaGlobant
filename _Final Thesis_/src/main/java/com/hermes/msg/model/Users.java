package com.hermes.msg.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="username",nullable = false)
	private String username;

	@Column(name="name",nullable = false)
	private String name;

	@Column(name="last_name",nullable = false)
	private String last_name;

	@Column(name="identification_number",nullable = false)
	private int identification_number;

	@Column(name="address",nullable = false)
	private String address;

	@Column(name="city",nullable = false)
	private String city;

	@Column(name="state",nullable = false)
	private String state;

	@Column(name="country",nullable = false)
	private String country;

	@Column(name="zip_code",nullable = false)
	private int zip_code;

	@Column(name="password",nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "users_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
	)
	private Collection<Role> roles;

	public Users(Long id, String username, String name, String last_name, int identification_number, String address, String city, String state, String country, int zip_code, String password, Collection<Role> roles) {
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
		this.roles = roles;
	}

	public Users(String username, String name, String last_name, int identification_number, String address, String city, String state, String country, int zip_code, String password, Collection<Role> roles) {
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
		this.roles = roles;
	}

	public Users() {
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users{" +
				"id=" + id +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				", last_name='" + last_name + '\'' +
				", identification_number=" + identification_number +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				", zip_code=" + zip_code +
				", password='" + password + '\'' +
				", roles=" + roles +
				'}';
	}
}
