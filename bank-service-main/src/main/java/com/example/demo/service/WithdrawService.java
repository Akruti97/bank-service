package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Withdraw;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.WithdrawRepository;
import com.example.demo.repository.depositRepository;

@Service
public class WithdrawService {
	
	@Autowired
	private WithdrawRepository withdrawRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private depositRepository depositRepository;
	
	public void makeWithdraw(Withdraw withdraw) {
		Integer accountNumber = Integer.parseInt(withdraw.getAccountnum());
		Account account = accountRepository.findById(accountNumber).get();
		
		Double initial_amount = account.getInitalDep();
		Double total_amount = initial_amount - withdraw.getWthAmt();
		
		account.setInitalDep(total_amount);
		accountRepository.save(account);
		
	
	}

}
