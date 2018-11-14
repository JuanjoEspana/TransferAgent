package com.digitalorigin.transferAgent.dao;

import com.digitalorigin.transferAgent.entities.Bank;

public interface BankDao {

	Bank add(final Bank bank);
	
	Bank get(final long id);
}
