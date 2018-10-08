package com.shopee.tax.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopee.tax.model.BillObject;
import com.shopee.tax.model.BillRequest;
import com.shopee.tax.model.BillReturnObject;
import com.shopee.tax.model.TaxObject;
import com.shopee.tax.repository.BillRepository;

@Service
public class BillService {
	@Autowired BillRepository billRepository;
	@Autowired TaxService taxService;
	
	public Map<String, Object> createBill(List<BillRequest> request) throws Exception {
		List<BillObject> billObjects = new ArrayList<>();
		String billId = UUID.randomUUID().toString();
		for (BillRequest obj : request) {
			TaxObject taxObject =  taxService.get(obj.getName());
			BillObject billObject = new BillObject(taxObject, obj.getQuantity(), billId);
			billObjects.add(billObject);
		}
		billRepository.save(billObjects);
		return generateBill(billObjects);
	}
	
	public Map<String, Object> getBill(String billId) throws Exception{
		List<BillObject> billObjects = billRepository.findByBillId(billId);
		if(billObjects.isEmpty()) {
			throw new Exception("Data not Found");
		}
		return generateBill(billObjects);
	}
	
	private Map<String, Object> generateBill(List<BillObject> objs){
		Map<String, Object> returnMap = new HashMap<>();
		List<BillReturnObject> returnList = new ArrayList<>();
		BigDecimal subTotal = new BigDecimal(0);
		BigDecimal subTotalTax = new BigDecimal(0);
		BigDecimal total = new BigDecimal(0);
		for (BillObject billObject : objs) {
			BillReturnObject returnObject =  new BillReturnObject(billObject.getTaxObject(), billObject.getQuantity());
			subTotal = subTotal.add(returnObject.getPriceTotal());
			subTotalTax = subTotalTax.add(returnObject.getTaxTotal());
			total = total.add(returnObject.getAmount());
			returnList.add(returnObject);
		}
		returnMap.put("billId",objs.get(0).getId());
		returnMap.put("returnList",returnList);
		returnMap.put("subTotal",subTotal);
		returnMap.put("subTotalTax", subTotalTax);
		returnMap.put("total", total);
		return returnMap;		
	}
}
