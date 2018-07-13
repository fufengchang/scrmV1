package com.vance.scrm.service.impl;

import com.vance.scrm.dao.ILoginStatusDao;
import com.vance.scrm.dao.impl.LoginStatusDaoImpl;
import com.vance.scrm.po.LoginStatus;
import com.vance.scrm.service.ILoginStatusService;

public class LoginStatusServiceImpl implements ILoginStatusService {
	private ILoginStatusDao dao = new LoginStatusDaoImpl();
	
	@Override
	public LoginStatus persist(LoginStatus status) {
		return dao.persist(status);
	}

	@Override
	public LoginStatus update(LoginStatus status) {
		return dao.update(status);
	}

}
