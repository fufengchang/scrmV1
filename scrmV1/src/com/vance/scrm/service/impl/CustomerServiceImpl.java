package com.vance.scrm.service.impl;

import java.util.List;

import com.vance.scrm.dao.ICustomerDao;
import com.vance.scrm.dao.impl.CustomerDaoFakeImpl;
import com.vance.scrm.po.Customer;
import com.vance.scrm.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	private ICustomerDao dao = new CustomerDaoFakeImpl();
	
	public Customer login(String cname, String password) {
		return dao.find(cname, password);
	}

	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer delete(String cname) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer add(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer update(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

}
