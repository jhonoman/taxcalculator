package com.shopee.tax.model;

import java.math.BigDecimal;

public class BillReturnObject {
	private String name;
	private int taxCode;
	private String type;
	private int quantity;
	private boolean refundable;
	private BigDecimal price;
	private BigDecimal priceTotal;
	private double tax;
	private BigDecimal taxTotal;
	private BigDecimal amount;
	public BillReturnObject(TaxObject obj, int quantity) {
		this.name = obj.getName();
		this.taxCode =  obj.getTaxCode();
		this.price = obj.getPrice();
		if(obj.getTaxCode() == 1) {
			this.type = "food and beverage";
			this.refundable = true;
			this.tax = 0.1d*obj.getPrice().doubleValue();
		}else if(obj.getTaxCode() == 2) {
			this.type = "tobacco";
			this.refundable = false;
			this.tax =10d+ 0.02d*obj.getPrice().doubleValue();
		}else {
			this.type = "Entertainment";
			this.refundable = false;
			this.tax = obj.getPrice().intValue()<100?0d:0.01d*(obj.getPrice().doubleValue()-100d);
		}
		this.quantity = quantity;
		this.priceTotal = obj.getPrice().multiply(new BigDecimal(quantity));
		this.taxTotal = (BigDecimal.valueOf(this.tax)).multiply(new BigDecimal(quantity));
		this.amount = priceTotal.add(taxTotal);
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isRefundable() {
		return refundable;
	}
	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTaxTotal() {
		return taxTotal;
	}
	public void setTaxTotal(BigDecimal taxTotal) {
		this.taxTotal = taxTotal;
	}
	public BigDecimal getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}
	
}
