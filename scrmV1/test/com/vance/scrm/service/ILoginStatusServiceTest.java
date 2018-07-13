package com.vance.scrm.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vance.scrm.po.LoginStatus;
import com.vance.scrm.service.impl.LoginStatusServiceImpl;

public class ILoginStatusServiceTest {
	ILoginStatusService service;
	
	@Before
	public void before() {
		service = new LoginStatusServiceImpl();
	}
	
	@Test
	public void testPersist() {
		LoginStatus status = new LoginStatus("Joy", "success", new Date());
		Assert.assertNotNull(service.persist(status));
	}
	
	@Test
	public void testUpdate() {
		LoginStatus status = new LoginStatus("Joy", "fail", new Date());
		Assert.assertNotNull(service.update(status));
	}
}
