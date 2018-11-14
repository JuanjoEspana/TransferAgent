package com.digitalorigin.transferAgent.dao.impl;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.digitalorigin.transferAgent.dao.BankDao;
import com.digitalorigin.transferAgent.entities.Bank;

@Repository
public class BankDaoImpl implements BankDao {
	
	//For test purposes, I'll keep data in memory
	HashMap<Long, Bank> storedBanks;
	// Generator to simulate auto generated ID from DB
	final AtomicLong counter = new AtomicLong();
	
	@PostConstruct
	private void init() {
		storedBanks = new HashMap<Long, Bank>();
	}
	
	public Bank add(Bank bank) {
		final Long id = counter.getAndIncrement();
		bank.setId(id);
		storedBanks.put(id, bank);
		
		return bank;
	}
	
	public Bank get(long id) {		
		return storedBanks.get(id);
	}
	


}
