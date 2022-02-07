package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accid;
	
	//Customer ID
	@Pattern(regexp = "[0-9 ]+")
	@Size(max = 10)
	@NotBlank
	@NotNull
	private String custId;
	
	//Type of Account
	@Pattern(regexp ="^Saving?$|^Current?$")
	@NotBlank
	private String accType;
	
	//Initial Deposit
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?")
	@Range(min = 500)
	private Double initalDep;
	
	//Customer Mapping
	@OneToOne(mappedBy = "account")
	private Customer customer;
	
	//Deposit Mapping
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Deposit> deposits;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Deposit> withdraw;
	
	public List<Deposit> getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(List<Deposit> withdraw) {
		this.withdraw = withdraw;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Deposit> getDeposits() {
		return deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Double getInitalDep() {
		return initalDep;
	}

	public void setInitalDep(Double initalDep) {
		this.initalDep = initalDep;
	}
	
	
}
