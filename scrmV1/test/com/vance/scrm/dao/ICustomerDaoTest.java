package com.vance.scrm.dao;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vance.scrm.dao.impl.CustomerDaoFakeImpl;
import com.vance.scrm.po.Customer;

public class ICustomerDaoTest {
	private ICustomerDao dao = null;
	
	@Before
	public void before() {
		dao = new CustomerDaoFakeImpl();
	}
	
	@Test
	public void testFind() {
		String customerName = "ben"; 
		String customerPwd = "123456";
		Assert.assertNotNull(dao.find(customerName, customerPwd));
	}

	@Test
	public void testFindAll() {
		Assert.assertEquals(dao.findAll().isEmpty(), false);
	}

	@Test
	public void testPersist() {
		Customer customer = new Customer("0003", "Kobe", "123456", "US");
		Assert.assertNull(dao.persist(customer));
	}

	@Test
	public void testRemove() {
		Customer customer = new Customer("0003", "Kobe", "123456", "US");
		Assert.assertNotNull(dao.persist(customer));
	}

	@Test
	public void testUpdate() {
		Customer customer = new Customer("0003", "Kobe", "123456", "US");
		Assert.assertNull(dao.persist(customer));
	}

}
