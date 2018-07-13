package com.vance.scrm.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vance.scrm.dao.impl.LoginStatusDaoImpl;
import com.vance.scrm.po.LoginStatus;


public class ILoginStatusDaoTest {
	ILoginStatusDao dao;
	
	@Before
	public void before() {
		dao = new LoginStatusDaoImpl();
	}
	
	@Test
	public void testPersist() {
		LoginStatus status = new LoginStatus("James", "fail", new Date());
		Assert.assertNotNull(dao.persist(status));
	}
	
	@Test
	public void testUpdate() {
		LoginStatus status = new LoginStatus("James", "success", new Date());
		Assert.assertNotNull(dao.update(status));
	}
	

}
