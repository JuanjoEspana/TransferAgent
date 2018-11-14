package com.digitalorigin.transferAgent.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.stereotype.Repository;

import com.digitalorigin.transferAgent.dao.TransferDao;
import com.digitalorigin.transferAgent.entities.Transfer;

@Repository
public class TransferDaoImpl implements TransferDao {

	final HashMap<Long, Transfer> storedTransfers = new HashMap<Long, Transfer>();
	final AtomicLong counter = new AtomicLong();
	
	public Transfer add(final Transfer transfer) {
		final Long id = counter.getAndIncrement();
		transfer.setId(id);
		storedTransfers.put(id, transfer);
		return transfer;
	}

	public List<Transfer> getCustomerTransfers(final long customerId) {
		final List<Transfer> filteredList = new LinkedList<Transfer>();
		filteredList.addAll(storedTransfers.values());
		CollectionUtils.filter(filteredList, new Predicate<Transfer>() {

			public boolean evaluate(Transfer t) {
				return t.getTransmitterId() == customerId || t.getReceiverId() == customerId;
			}
		});
		
		return filteredList;
	}

}
