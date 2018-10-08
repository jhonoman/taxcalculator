package com.shopee.tax.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tax_object")
public class TaxObject {
	@Id
	@NotBlank
	private String name;
	private int taxCode; //1. Food and beverage 2. tobacco 3. entertainment
	private BigDecimal price;
	public TaxObject() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(int taxCode) {
		this.taxCode = taxCode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
