package com.digitalorigin.transferAgent.service;

import java.util.List;

import com.digitalorigin.transferAgent.entities.Transfer;

public interface TransferService {

	Transfer add(final long transmitterId, final long receiverId, double amount) throws Exception;
	List<Transfer> getCustomerTransfers(final long customerId );
}
