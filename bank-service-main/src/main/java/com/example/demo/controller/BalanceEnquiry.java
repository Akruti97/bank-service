package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Deposit;
import com.example.demo.service.AccountService;

@RestController
public class BalanceEnquiry {
	@Autowired
	AccountService accountService;
	
	@GetMapping("/{id}/enquiry")
	Optional<Deposit> getCustomer(@PathVariable("id") Integer depoid) {
		return accountService.getDeposit(depoid);
	}

}
