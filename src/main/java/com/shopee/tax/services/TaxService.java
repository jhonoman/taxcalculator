package com.shopee.tax.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopee.tax.model.TaxObject;
import com.shopee.tax.repository.TaxRepository;

@Service
public class TaxService {
	@Autowired
	TaxRepository taxRepository;
	
	public Object createTaxObject(TaxObject obj) throws Exception {
		if(taxRepository.findOne(obj.getName()) != null) {
			throw new Exception("Data Already Exist!");
		}else if(obj.getTaxCode()<1 || obj.getTaxCode() >3) {
			throw new Exception("Tax Code not Found!");
		}else if(obj.getPrice().intValue() <0 ) {
			throw new Exception("price must be more than 0!");
		}
		return taxRepository.save(obj);
	}
	
	public Object updateTaxObject(TaxObject obj) throws Exception {
		TaxObject taxObject = this.get(obj.getName());
		taxObject.setTaxCode(0 == obj.getTaxCode() ? taxObject.getTaxCode() : obj.getTaxCode());
		taxObject.setPrice(null == obj.getPrice()? taxObject.getPrice(): obj.getPrice());
		if(taxObject.getTaxCode()<1 || taxObject.getTaxCode() >3) {
			throw new Exception("Tax Code not Found!");
		}else if(taxObject.getPrice().intValue() <0 ) {
			throw new Exception("price must be more than 0!");
		}
		return taxRepository.save(taxObject);
	}
	
	public void deleteTaxObject(String name) throws Exception {
		this.get(name);
		taxRepository.delete(name);
	}
	
	public List<TaxObject> getAll(){
		return (List<TaxObject>) taxRepository.findAll();
	}
	
	public TaxObject get(String name) throws Exception{
		TaxObject obj = taxRepository.findOne(name);
		if(obj == null) {
			throw new Exception("Data not Found");
		}
		return obj;
	}
}
