package com.shopee.tax.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill_object")
public class BillObject {
	@Id
	private String id;
	@ManyToOne(optional = true)
    @JoinColumn(name = "tax_object_id")
	private TaxObject taxObject;
	private int quantity;
	private String billId;
	public BillObject() {
		this.id = UUID.randomUUID().toString();
	}
	public BillObject(TaxObject taxObject, int quantity, String billId) {
		this.id = UUID.randomUUID().toString();
		this.taxObject = taxObject;
		this.quantity = quantity;
		this.billId = billId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TaxObject getTaxObject() {
		return taxObject;
	}
	public void setTaxObject(TaxObject taxObject) {
		this.taxObject = taxObject;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
