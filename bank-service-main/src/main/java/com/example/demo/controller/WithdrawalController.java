package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Withdraw;
import com.example.demo.service.WithdrawService;

@RestController
public class WithdrawalController extends CustomerController{
	@Autowired
	private WithdrawService withdrawService;
	@PostMapping("/withdraw")
	@ResponseStatus(code = HttpStatus.CREATED)
	void makeWithdraw(@RequestBody @Valid Withdraw withdraw, @PathVariable("id") Integer id) {
		withdrawService.makeWithdraw(withdraw);
	}
	
}
