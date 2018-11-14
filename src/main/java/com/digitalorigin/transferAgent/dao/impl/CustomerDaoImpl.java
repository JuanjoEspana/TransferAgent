package com.digitalorigin.transferAgent.dao.impl;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalorigin.transferAgent.dao.CustomerDao;
import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.entities.Customer;

@Service
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	BankDaoImpl bankDao;
	//For test purposes, I'll keep data in memory 
	HashMap<Long, Customer> storedCustomers;
	final AtomicLong counter = new AtomicLong();
	
	@PostConstruct
	private void init() {
		storedCustomers = new HashMap<Long, Customer>();
	}
	
	public Customer add(Customer customer) {
		final Long id = counter.getAndIncrement();
		customer.setId(id);
		storedCustomers.put(id, customer);
		
		return customer;
	}

	
	public Customer get(long id) {		
		return storedCustomers.get(id);
	}

	
	public Bank getCustomerBank(Customer customer) {
		return bankDao.get(customer.getBankId());
	}

}
