package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//Customer Name
	@NotNull
	@Size(max = 25)
	@Pattern(regexp ="^[a-zA-Z\s]+$")
	private String name;
	
	//Gender
	@NotBlank
	@NotNull
	@Pattern(regexp ="^M(ale)?$|^F(emale)?$")
	private String gender;
	
	//Date of birth
	@NotBlank
	@NotNull
	@Pattern(regexp = "^(([0-9])|([0-2][0-9])|([3][0-1]))\\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\-\\d{4}$")
	private String dob;
	
	//Address
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String address;
	
	//City
	@NotBlank
	@NotNull
	@Size(max = 25)
	@Pattern(regexp ="^[a-zA-Z\s]+$")
	private String city;
	
	//State
	@NotBlank
	@NotNull
	@Size(max = 25)
	@Pattern(regexp ="^[a-zA-Z\s]+$")
	private String state;
	
	//ZIP/PIN
	@NotBlank
	@NotNull
	@Pattern(regexp = "[0-9 ]+")
	@Size(max = 7)
	private String pin;
	
	//Telephone
	@Pattern(regexp = "[0-9 ]+")
	@Size(max = 15)
	private String tel;
	
	//FAX
	@Size(max = 15)
	@Pattern(regexp = "[0-9 ]+")
	private String fax;
	
	//Email
	@Email
	@NotNull
	@NotBlank
	@Size(max = 30)
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id_ref", referencedColumnName = "accid")
	private Account account;


	public Customer(){
		
	}
	
	public Customer(Integer Id, @NotBlank @Size(max = 25) @Pattern(regexp = "^[a-zA-Z ]+$") String name,
			@NotBlank String gender,
			@NotBlank @Pattern(regexp = "^(([0-9])|([0-2][0-9])|([3][0-1]))\\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\-\\d{4}$") String dob,
			@NotBlank @Size(max = 50) String address,
			@NotBlank @Size(max = 25) @Pattern(regexp = "^[a-zA-Z ]+$") String city,
			@NotBlank @Size(max = 25) @Pattern(regexp = "^[a-zA-Z ]+$") String state,
			@NotBlank @Pattern(regexp = "[0-9 ]+") @Size(max = 7) String pin,
			@Pattern(regexp = "[0-9 ]+") @Size(max = 15) String tel,
			@Size(max = 15) @Pattern(regexp = "[0-9 ]+") String fax,
			@Email @NotBlank @Size(max = 30) @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") String email,
			Account account) {
		super();
		this.id = Id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.account = account;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
