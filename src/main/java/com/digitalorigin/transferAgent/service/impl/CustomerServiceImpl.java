package com.digitalorigin.transferAgent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalorigin.transferAgent.dao.CustomerDao;
import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.entities.Customer;
import com.digitalorigin.transferAgent.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	public Customer add(Customer customer) {		
		return dao.add(customer);
	}

	public Customer get(long id) {		
		return dao.get(id);
	}

	public Bank getCustomerBank(Customer customer) {		
		return dao.getCustomerBank(customer);
	}
	

}
