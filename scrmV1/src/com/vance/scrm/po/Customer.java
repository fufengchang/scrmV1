package com.vance.scrm.po;

import java.io.Serializable;

public class Customer implements Serializable{
	private String customerId;
	private String customerName;
	private String customerPwd;
	private String location;
	
	public Customer() {
		
	}

	public Customer(String customerId, String customerName, String customerPwd, String location) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPwd = customerPwd;
		this.location = location;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
