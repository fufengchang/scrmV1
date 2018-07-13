package com.vance.scrm.po;

import java.util.Date;

public class LoginStatus {
	private String customerName;
	private String loginStatus;
	private Date date;
	
	public LoginStatus() {}
	
	public LoginStatus(String customerName, String loginStatus, Date date) {
		super();
		this.customerName = customerName;
		this.loginStatus = loginStatus;
		this.date = date;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "LoginStatus [customerName=" + customerName + ", loginStatus=" + loginStatus + ", date=" + date + "]";
	}

	
}	
