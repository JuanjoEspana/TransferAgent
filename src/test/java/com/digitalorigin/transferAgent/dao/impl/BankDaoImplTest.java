package com.digitalorigin.transferAgent.dao.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalorigin.transferAgent.TransferAgentApplication;
import com.digitalorigin.transferAgent.dao.BankDao;
import com.digitalorigin.transferAgent.entities.Bank;

@RunWith(SpringRunner.class)
@SpringBootTest(		  
		  classes = TransferAgentApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankDaoImplTest {	
	
	@Autowired
	BankDao dao;

	@Test
	public void testCreate() {
		final Bank bank = new Bank();
				
		bank.setName("Test Bank");
		
		final Bank createdBank = dao.add(bank);
		
		Assert.assertNotNull(createdBank);
		Assert.assertEquals(0, createdBank.getId());
		Assert.assertEquals("Test Bank", createdBank.getName());
	}

	
	@Test
	public void testGet() {		
		final Bank recoveredBank = dao.get(0);
		
		Assert.assertNotNull(recoveredBank);
		Assert.assertEquals("Test Bank", recoveredBank.getName());
	}
}
