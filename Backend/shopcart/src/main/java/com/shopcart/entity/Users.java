package com.shopcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shopcart.login.Encryption;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "mobile_no")
	private String mobile_no;
	
	@Column(name = "email_id")
	private String email_id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "zip_code")
	private String zip_code;
	
	@Column(name = "password")
	private String password;
	
	public Users () {
		
	}
	
	

	public Users(int user_id, String first_name, String last_name, String username, String gender, String mobile_no,
			String email_id, String address, String state, String city, String street, String zip_code,
			String password) {

		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.gender = gender;
		this.mobile_no = mobile_no;
		this.email_id = email_id;
		this.address = address;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zip_code = zip_code;
		this.password = password;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String encryptedPassword = Encryption.encrypt(password, "secretkey"); 
		this.password = encryptedPassword;
	}



	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", gender=" + gender + ", mobile_no=" + mobile_no + ", email_id=" + email_id + ", address="
				+ address + ", state=" + state + ", city=" + city + ", street=" + street + ", zip_code=" + zip_code
				+ ", password=" + password + "]";
	}
	
}
