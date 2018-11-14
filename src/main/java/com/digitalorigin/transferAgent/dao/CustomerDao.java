package com.digitalorigin.transferAgent.dao;

import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.entities.Customer;

public interface CustomerDao {

	Customer add(final Customer customer);
	Customer get(final long id);
	Bank getCustomerBank(final Customer customer);
}
