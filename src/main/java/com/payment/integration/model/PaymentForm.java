package com.payment.integration.model;

import java.math.BigDecimal;

public class PaymentForm {
	
	
	private String customerName;
	
	private String tokenId;
	
	private String deviceSessionId;
	
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getDeviceSessionId() {
		return deviceSessionId;
	}

	public void setDeviceSessionId(String deviceSessionId) {
		this.deviceSessionId = deviceSessionId;
	}
	
	

}
