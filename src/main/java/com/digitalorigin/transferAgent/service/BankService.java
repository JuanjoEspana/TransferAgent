package com.digitalorigin.transferAgent.service;

import com.digitalorigin.transferAgent.entities.Bank;

public interface BankService {

	Bank add(final Bank bank);
	
	Bank get(final long id);
	
}
