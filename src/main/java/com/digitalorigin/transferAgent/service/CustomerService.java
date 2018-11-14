package com.digitalorigin.transferAgent.service;

import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.entities.Customer;

public interface CustomerService {

	Customer add(final Customer customer);
	
	Customer get(final long id);
	
	Bank getCustomerBank(final Customer customer);
}
