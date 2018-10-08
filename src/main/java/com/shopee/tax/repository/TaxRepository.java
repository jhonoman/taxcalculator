package com.shopee.tax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopee.tax.model.TaxObject;

@Repository
public interface TaxRepository  extends CrudRepository<TaxObject, String>{
}
