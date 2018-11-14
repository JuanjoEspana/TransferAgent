package com.digitalorigin.transferAgent.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalorigin.transferAgent.dao.TransferDao;
import com.digitalorigin.transferAgent.entities.Account;
import com.digitalorigin.transferAgent.entities.Bank;
import com.digitalorigin.transferAgent.entities.Customer;
import com.digitalorigin.transferAgent.entities.Transfer;
import com.digitalorigin.transferAgent.entities.TransferStatus;
import com.digitalorigin.transferAgent.entities.TransferType;
import com.digitalorigin.transferAgent.service.AccountService;
import com.digitalorigin.transferAgent.service.CustomerService;
import com.digitalorigin.transferAgent.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	TransferDao dao;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerService customerService;

	public Transfer add(long transmitterId, long receiverId, double amount) throws Exception {
		final TransferType type = checkTransferType(transmitterId, receiverId);
		final Transfer transfer = new Transfer();
		
		transfer.setTransmitterId(transmitterId);
		transfer.setReceiverId(receiverId);
		transfer.setType(type);
		
		if(TransferType.INTRA_BANK_DIFFERENT_BANK.equals(type)) {
			try {
				handleTransferTypeLimitations(transfer, amount);
			}catch(Exception e) {
				// log the error and save it as failure
			}
		} else {
			transfer.setAmount(amount);
			transfer.setStatus(TransferStatus.SUCCESS);
		}
		
		dao.add(transfer);
		
		return transfer;
	}

	public List<Transfer> getCustomerTransfers(long customerId) {
		return dao.getCustomerTransfers(customerId);
	}

	private TransferType checkTransferType(final long transmitterId, final long receiverId) throws Exception {
		final Account transmitterAcc = accountService.get(transmitterId);
		final Account receiverAcc = accountService.get(receiverId);
		
		final Customer transmiterCus = customerService.get(transmitterAcc.getCustomerId());
		final Customer receiverCus = customerService.get(receiverAcc.getCustomerId());
		
		final Bank transmitterBank = customerService.getCustomerBank(transmiterCus);
		final Bank receiverBank = customerService.getCustomerBank(receiverCus);
		
		if(transmitterBank == null || receiverBank == null) {
			throw new Exception("Unable to recover bank for provided account(s).");
		} else if(transmitterBank.getId() == receiverBank.getId()){
			return TransferType.INTRA_BANK_SAME_BANK;
		} else {
			return TransferType.INTRA_BANK_DIFFERENT_BANK;
		}		
	}
	
	private void handleTransferTypeLimitations(final Transfer transfer, final double amount) throws Exception {
		if(amount > 1000) {
			//Applied commision
			transfer.setAmount(995.0);
			transfer.setStatus(TransferStatus.LIMITED);
		} else if(amount<5) {
				throw new Exception("Money transfered too low to pay the required comission.");
		}
		transfer.setAmount(amount - 5);
		Random r = new Random();
		int failureChance = r.nextInt(100) + 1;
		
		if(failureChance<=30) {
			transfer.setStatus(TransferStatus.FAILURE);
			throw new Exception("There was an error when trying to execute the transaction.");
		} else { 
			transfer.setStatus(TransferStatus.SUCCESS);
		}
		
	}
}
