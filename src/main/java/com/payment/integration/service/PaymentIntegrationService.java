package com.payment.integration.service;

import org.springframework.stereotype.Service;

import com.payment.integration.model.PaymentForm;

import mx.openpay.client.Customer;
import mx.openpay.client.core.OpenpayAPI;
import mx.openpay.client.core.requests.transactions.CreateCardChargeParams;

@Service
public class PaymentIntegrationService {
	
	
	public void makePayment(PaymentForm paymentForm) {
		
		OpenpayAPI api = new OpenpayAPI("https://sandbox-api.openpay.mx",
				  "sk_e568c42a6c384b7ab02cd47d2e407cab", "mzdtln0bmtms6o3kck8f");
		
		Customer customer = new Customer();
		customer.setName(paymentForm.getCustomerName());
		
		CreateCardChargeParams charge = new CreateCardChargeParams()
                .cardId(paymentForm.getDeviceSessionId())
                .amount(paymentForm.getAmount())
                .description(description)
                .deviceSessionId(deviceSessionId)
                .customer(customer);
		
		
		
	}
	
	

}
