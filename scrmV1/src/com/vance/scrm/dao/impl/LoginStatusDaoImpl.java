package com.vance.scrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vance.scrm.dao.ILoginStatusDao;
import com.vance.scrm.po.LoginStatus;
import com.vance.scrm.util.BDCPUtil;

public class LoginStatusDaoImpl implements ILoginStatusDao {
	@Override
	public LoginStatus persist(LoginStatus status) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "insert into login_status(customer_name, login_status, login_time) "
					+"values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status.getCustomerName());
			ps.setString(2, status.getLoginStatus());
			ps.setString(3, status.getDate().toString());
			if(ps.executeUpdate() != 0) {
				return status;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LoginStatus update(LoginStatus status) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "update login_status set login_status=? , login_time=? where customer_name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status.getLoginStatus());
			ps.setString(2, status.getDate().toString());
			ps.setString(3, status.getCustomerName());
			if(ps.executeUpdate() != 0) {
				return status;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
