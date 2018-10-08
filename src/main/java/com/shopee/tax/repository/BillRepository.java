package com.shopee.tax.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopee.tax.model.BillObject;

@Repository
public interface BillRepository extends CrudRepository<BillObject, String>{
	List<BillObject> findByBillId(String billId);
}
