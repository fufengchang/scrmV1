package com.vance.scrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vance.scrm.dao.ICustomerDao;
import com.vance.scrm.po.Customer;
import com.vance.scrm.util.BDCPUtil;

public class CustomerDaoFakeImpl implements ICustomerDao {
	
	@Override
	public Customer find(String customerName, String customerPwd) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "select customer_id, customer_name, customer_pwd, customer_location from customer "
				   + "where customer_name=? and customer_pwd=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customerName);
			ps.setString(2, customerPwd);
			ResultSet rs = ps.executeQuery();
			Customer customer = null;
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerPwd(rs.getString(3));
				customer.setLocation(rs.getString(4));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> findAll() {
		Connection conn = BDCPUtil.getConnection();
		String sql = "select customer_id, customer_name, customer_pwd, customer_location from customer";
		List<Customer> customers = new ArrayList<Customer>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerPwd(rs.getString(3));
				customer.setLocation(rs.getString(4));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer persist(Customer c) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "insert into customer(customer_id, customer_name, customer_pwd, customer_location)"
					+"values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCustomerId());
			ps.setString(2, c.getCustomerName());
			ps.setString(3, c.getCustomerPwd());
			ps.setString(4, c.getLocation());
			int a = ps.executeUpdate();
			if(a != 0) {
				System.out.println(a);
				return c;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer remove(Customer c) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "delete from customer where customer_id = ?";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCustomerId());
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer update(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

}
