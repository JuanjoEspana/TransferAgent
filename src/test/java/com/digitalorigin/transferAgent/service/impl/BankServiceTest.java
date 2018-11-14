package com.digitalorigin.transferAgent.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalorigin.transferAgent.TransferAgentApplication;
import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.service.BankService;

@RunWith(SpringRunner.class)
@SpringBootTest(		  
		  classes = TransferAgentApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankServiceTest {
	
	@Autowired
	BankService service;

	@Test
	public void testAdd() {
		final Bank bank = new Bank();		
		
		bank.setName("Test Bank");
		
		final Bank createdBank = service.add(bank);
		
		Assert.assertNotNull(createdBank);
		Assert.assertEquals(1,  bank.getId());
		Assert.assertEquals("Test Bank", createdBank.getName());
	}

	@Test
	public void testGet() {
		final Bank recoveredBank = service.get(0);
		
		Assert.assertNotNull(recoveredBank);
		Assert.assertEquals("Test Bank", recoveredBank.getName());
	}

}
