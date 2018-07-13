package com.vance.scrm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vance.scrm.po.Customer;
import com.vance.scrm.service.impl.CustomerServiceImpl;

import junit.framework.TestCase;

public class ICustomerServiceTest extends TestCase {
	private ICustomerService service = new CustomerServiceImpl();;
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void testLogin() {
		String customerName = "ben";
		String customerPwd = "123456";
		Customer c = service.login(customerName, customerPwd);
		Assert.assertNotNull(c);
	}

	public void testListAll() {
		fail("Not yet implemented");
	}

	public void testDelete() {
		fail("Not yet implemented");
	}

	public void testAdd() {
		fail("Not yet implemented");
	}

	public void testUpdate() {
		fail("Not yet implemented");
	}

}
