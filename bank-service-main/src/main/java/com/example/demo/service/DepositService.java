package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Deposit;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.depositRepository;

@Service
public class DepositService {

	@Autowired
	private depositRepository depositRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	public void addDeposit(Deposit deposit) {
		
		Integer accountNumber = Integer.parseInt(deposit.getAccountnum());
		Account account = accountRepository.findById(accountNumber).get();	
		
		Double initial_amount = account.getInitalDep();
		Double total_amount = initial_amount + deposit.getAmount();
		
		account.setInitalDep(total_amount);
		account.getDeposits().add(deposit);
		accountRepository.save(account);
	}
	
}