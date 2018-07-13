package com.vance.scrm.dao;

import java.util.List;

import com.vance.scrm.po.Customer;

public interface ICustomerDao {
	Customer find(String customerName, String customerPwd);
	
	List<Customer> findAll();
	
	Customer persist(Customer c);
	
	Customer remove(Customer c);
	
	Customer update(Customer c);
}
