package com.payment.integration.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.payment.integration.model.PaymentForm;

import mx.openpay.client.Charge;
import mx.openpay.client.Customer;
import mx.openpay.client.core.OpenpayAPI;
import mx.openpay.client.core.operations.ChargeOperations;
import mx.openpay.client.core.requests.RequestBuilder;
import mx.openpay.client.core.requests.transactions.CreateCardChargeParams;
import mx.openpay.client.exceptions.OpenpayServiceException;
import mx.openpay.client.exceptions.ServiceUnavailableException;

@Service
public class PaymentIntegrationService {
	
	
	@SuppressWarnings("deprecation")
	public void makePayment(PaymentForm paymentForm) {
		
		OpenpayAPI api = new OpenpayAPI("https://sandbox-api.openpay.mx",
				  "sk_e568c42a6c384b7ab02cd47d2e407cab", "mzdtln0bmtms6o3kck8f");
		
		Customer customer = new Customer();
		customer.setName(paymentForm.getCustomerName());
		
		CreateCardChargeParams charge = new CreateCardChargeParams()
                .cardId(paymentForm.getDeviceSessionId())
                .amount(paymentForm.getAmount())                
                .deviceSessionId(paymentForm.getDeviceSessionId())
                .customer(customer);
		
		try {
			
			Charge operations = api.charges().create(charge);
			BigDecimal amount = operations.getAmount();
			
			
		} catch (OpenpayServiceException e) {
			e.printStackTrace();
		} catch (ServiceUnavailableException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
