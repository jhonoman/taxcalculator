package com.shopee.tax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopee.tax.model.TaxObject;
import com.shopee.tax.services.TaxService;

@RestController
@RequestMapping("/api/tax")
public class TaxController {
	
	@Autowired
	TaxService taxService;
	/*
	 * This Method use for create new Object Tax 
	 * */
	@PostMapping
   	public Object createTaxObject(@RequestBody TaxObject request) throws Exception {
    	return taxService.createTaxObject(request);
    }
	/*
	 * This Method use for update Object Tax 
	 * */
	@PutMapping
   	public Object updateTaxObject(@RequestBody TaxObject request) throws Exception {
    	return taxService.updateTaxObject(request);
    }
	/*
	 * This Method use for delete Object Tax 
	 * */
	@DeleteMapping
   	public Object deleteTaxObject(@RequestParam String name) throws Exception {
		taxService.deleteTaxObject(name);
    	return "Success!";
    }
	/*
	 * This Method use for get one Object Tax or all object tax if you don't send param 
	 * */
	@GetMapping
   	public Object getTaxObject(@RequestParam(required =false) String name) throws Exception {
		if(name != null) {
			return taxService.get(name);
		}
    	return taxService.getAll();
    }
}
