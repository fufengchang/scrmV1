package com.vance.scrm.service;

import java.util.List;

import com.vance.scrm.po.Customer;

public interface ICustomerService {
	Customer login(String cname, String password);

	List<Customer> listAll();

	Customer delete(String cname);

	Customer add(Customer c);

	Customer update(Customer c);

}
