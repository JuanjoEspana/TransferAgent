package com.digitalorigin.transferAgent.entities;

public class Transfer {

	private long id;
	private long transmitterId;
	private long receiverId;
	private double amount;
	private TransferType type;
	private TransferStatus status;
	private String message;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTransmitterId() {
		return transmitterId;
	}
	public void setTransmitterId(long transmitterId) {
		this.transmitterId = transmitterId;
	}
	public long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransferType getType() {
		return type;
	}
	public void setType(TransferType type) {
		this.type = type;
	}
	public TransferStatus getStatus() {
		return status;
	}
	public void setStatus(TransferStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
