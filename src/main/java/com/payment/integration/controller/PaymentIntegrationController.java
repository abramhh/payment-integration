package com.payment.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payment.integration.model.PaymentForm;
import com.payment.integration.model.ClientInformation;
import com.payment.integration.service.PaymentIntegrationService;

@Controller
@RequestMapping("/payment")
public class PaymentIntegrationController {
	
	@Autowired
	private PaymentIntegrationService service;
	
	@RequestMapping(value = "/paymentPage", method = RequestMethod.GET)
	public String paymentPage(Model model) {
		PaymentForm paymentForm = new PaymentForm();
		
		model.addAttribute("payment", 2580);
		model.addAttribute("paymentForm", paymentForm);
		return "payment-card";
	}
	
	@RequestMapping(value = "/clientInformation", method = RequestMethod.GET)
	public String paymentInfoPage(Model model) {
		
		ClientInformation information = new ClientInformation();
		model.addAttribute("paymenInformation", information);
		
		return "client-information";
	}
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public String makePage(@ModelAttribute("paymentForm") PaymentForm paymentForm) {
		
		System.out.println(paymentForm.getDeviceSessionId());
		System.out.println(paymentForm.getTokenId());
		System.out.println(paymentForm.getCustomerName());
		service.makePayment(paymentForm);
		
		
		return "payment-card";
	}
}
