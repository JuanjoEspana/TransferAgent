package com.digitalorigin.transferAgent.dao.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalorigin.transferAgent.TransferAgentApplication;
import com.digitalorigin.transferAgent.dao.BankDao;
import com.digitalorigin.transferAgent.dao.CustomerDao;
import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.entities.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(		  
		  classes = TransferAgentApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoImplTest {

	@Mock
	static BankDao bankDao;
	
	@Autowired	
	CustomerDao dao;
	
	@BeforeClass
	public static void setUp() {

	}

	@Test
	public void testAdd() {
		final Customer customer = new Customer();
		customer.setName("Pepe");
		customer.setBankId(1);
		
		final Customer createdCustomer = dao.add(customer);
		
		Assert.assertNotNull(createdCustomer);
		Assert.assertEquals(0, createdCustomer.getId());
	}

	@Test
	public void testGet() {
		final Customer recoveredCustomer = dao.get(0);
		
		Assert.assertNotNull(recoveredCustomer);
		Assert.assertEquals("Pepe", recoveredCustomer.getName());
	}

	@Test
	public void testGetCustomerBank() {
	    bankDao = Mockito.mock(BankDaoImpl.class);
	    final Bank bank = new Bank();
	    bank.setId(1);
	    bank.setName("Pepes bank");
		Mockito.when(bankDao.get(Mockito.anyLong())).thenReturn(bank);
		Whitebox.setInternalState(dao, "bankDao", bankDao);
		
		final Customer recoveredCustomer = dao.get(0);
		final Bank mockedBank = dao.getCustomerBank(recoveredCustomer);
		
		Assert.assertNotNull(mockedBank);
		Assert.assertEquals("Pepes bank", mockedBank.getName());
	}

}
