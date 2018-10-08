package com.shopee.tax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopee.tax.model.BillRequest;
import com.shopee.tax.services.BillService;

@RestController
@RequestMapping("/api/bill")
public class BillController {
	
	@Autowired BillService billService;
	
	/*
	 * This Method use for create bill from customer
	 * */
	@PostMapping
	public Object createBill(@RequestBody List<BillRequest> request) throws Exception {
		return billService.createBill(request);
	}
	/*
	 * This Method use for get bill from customer
	 * */
	@GetMapping
	public Object getBill(@RequestParam String billId) throws Exception {
		return billService.getBill(billId);
	}
}
