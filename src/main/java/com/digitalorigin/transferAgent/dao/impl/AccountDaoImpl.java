package com.digitalorigin.transferAgent.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitalorigin.transferAgent.dao.AccountDao;
import com.digitalorigin.transferAgent.dao.TransferDao;
import com.digitalorigin.transferAgent.entities.Account;
import com.digitalorigin.transferAgent.entities.Transfer;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	final HashMap<Long, Account> storedAccounts = new HashMap<Long, Account>();
	final AtomicLong counter = new AtomicLong();

	@Autowired
	TransferDao transferDao;
	
	public Account add(Account account) {
		final Long id = counter.getAndIncrement();
		account.setId(id);
		storedAccounts.put(id, account);
		return account;
	}

	public Account get(long id) {
		return storedAccounts.get(id);
	}

	public List<Transfer> getTransfers(long id) {
		return transferDao.getCustomerTransfers(id);
	}

}
