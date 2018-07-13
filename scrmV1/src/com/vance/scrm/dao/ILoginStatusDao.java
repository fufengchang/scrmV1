package com.vance.scrm.dao;


import com.vance.scrm.po.LoginStatus;

public interface ILoginStatusDao {
	LoginStatus persist(LoginStatus status);
	LoginStatus update(LoginStatus status);
}
