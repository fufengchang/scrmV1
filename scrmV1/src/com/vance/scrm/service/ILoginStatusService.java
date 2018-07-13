package com.vance.scrm.service;

import com.vance.scrm.po.LoginStatus;

public interface ILoginStatusService {
	LoginStatus persist(LoginStatus status);
	LoginStatus update(LoginStatus status);
}
