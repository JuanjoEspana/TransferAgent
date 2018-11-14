package com.digitalorigin.transferAgent.dao;

import java.util.List;

import com.digitalorigin.transferAgent.entities.Account;
import com.digitalorigin.transferAgent.entities.Transfer;

public interface AccountDao {

	Account add(final Account account);
	Account get(final long id);
	List<Transfer> getTransfers(final long id);
	
}
