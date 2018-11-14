package com.digitalorigin.transferAgent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalorigin.transferAgent.dao.AccountDao;
import com.digitalorigin.transferAgent.entities.Account;
import com.digitalorigin.transferAgent.entities.Transfer;
import com.digitalorigin.transferAgent.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao dao;

	public Account add(Account account) {
		return dao.add(account);
	}

	public Account get(long id) {
		return dao.get(id);
	}

	public List<Transfer> getTransfers(long id) {
		return dao.getTransfers(id);
	}

}
