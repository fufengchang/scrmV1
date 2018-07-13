package com.vance.scrm.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.vance.scrm.po.LoginStatus;

public class JsonUtilTest {

	@Test
	public void testObjectToJson() {
		LoginStatus status = new LoginStatus("James", "fail", new Date());
		System.out.println(JsonUtil.objectToJson(status));
	}
	
	@Test
	public void testJsonToObject() {
		LoginStatus status = (LoginStatus)JsonUtil.jsonToObject("{\"customerName\""
				+ ":\"James\",\"loginStatus\":\"fail\",\"date\":1531324350081}", LoginStatus.class);
		System.out.println(status.toString());
	}

}
