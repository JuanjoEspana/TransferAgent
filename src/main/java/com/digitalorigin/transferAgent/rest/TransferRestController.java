package com.digitalorigin.transferAgent.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalorigin.transferAgent.entities.Account;
import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.entities.Customer;
import com.digitalorigin.transferAgent.entities.Transfer;
import com.digitalorigin.transferAgent.service.AccountService;
import com.digitalorigin.transferAgent.service.BankService;
import com.digitalorigin.transferAgent.service.CustomerService;
import com.digitalorigin.transferAgent.service.TransferService;

@RestController
public class TransferRestController {

	@Autowired
	TransferService service;
	
	@Autowired
	BankService bankService;
	@Autowired
	CustomerService customerService;
	@Autowired
	AccountService accountService;
	
	
	@RequestMapping(value="/transfer/{transmitterId}/{receiverId}/{amount}", method = RequestMethod.GET)
	public Transfer transfer( @PathVariable("transmitterId") long transmitterId,
			 @PathVariable("receiverId") long receiverId,
			 @PathVariable("amount") double amount) {
		
		try {
			setUp();
			return service.add(transmitterId, receiverId, amount);
		} catch (Exception e) {
			final Transfer transfer = new Transfer();
			transfer.setMessage("Error in request - Cause: "+e.getMessage());
			e.printStackTrace();
			return transfer;
		}
	}
	
	
	private void setUp() {
		Bank bank = new Bank();
		bank.setName("Bank 0");
		Bank bank2 = new Bank();
		bank2.setName("Bank 2");
		
		bank = bankService.add(bank);
		bank2 = bankService.add(bank2);
		
		Customer customer = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();
		
		customer.setName("User 1");
		customer.setBankId(bank.getId());
		
		customer2.setName("User 2");
		customer2.setBankId(bank2.getId());
		
		customer3.setName("User 3");
		customer3.setBankId(bank.getId());
		
		customer = customerService.add(customer);
		customer2 = customerService.add(customer2);
		customer3 = customerService.add(customer3);
		
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setCustomerId(customer.getId());
		acc1.setMoney(100000.0);
		acc2.setCustomerId(customer2.getId());
		acc2.setMoney(20000.0);
		
		accountService.add(acc1);
		accountService.add(acc2);
	}
}
