package com.digitalorigin.transferAgent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalorigin.transferAgent.dao.BankDao;
import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankDao dao;
	
	public Bank add(Bank bank) {
		return dao.add(bank);
	}

	public Bank get(long id) {
		return dao.get(id);
	}

}
