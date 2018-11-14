package com.digitalorigin.transferAgent.dao;

import java.util.List;

import com.digitalorigin.transferAgent.entities.Transfer;

public interface TransferDao {

	Transfer add(final Transfer transfer);
	List<Transfer> getCustomerTransfers(final long customerId );
}
