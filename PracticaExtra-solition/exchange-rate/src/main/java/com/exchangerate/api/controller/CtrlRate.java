package com.exchangerate.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exchangerate.api.dto.DtoRate;
import com.exchangerate.api.service.SvcRate;

@RestController
@RequestMapping("/exchange-rate")
public class CtrlRate {
	
	@Autowired
	SvcRate svc;
	
	@GetMapping("/{currency}")
	public ResponseEntity<DtoRate> getCustomers(@PathVariable("currency") String currency){
		return new ResponseEntity<>(svc.getRate(currency), HttpStatus.OK);
	}
}
