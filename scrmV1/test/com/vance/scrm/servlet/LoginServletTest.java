package com.vance.scrm.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class LoginServletTest {
	OutputStream out = new ByteArrayOutputStream();

	@Before
	public void before() {
		// System.setOut(new PrintStream(out));
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse()
			throws MalformedURLException, IOException, ServletException, SAXException {
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		// 向指定的URL发出请求
		WebRequest req = new PostMethodWebRequest("http://localhost:9999/scrmV1/login.do");
		// 给请求加上参数
		req.setParameter("customerName", "ben");
		req.setParameter("customerPwd", "12345");
		// 获取响应对象
		WebResponse resp = wc.getResponse(req);
		// 用getText方法获取相应的全部内容
		// 用System.out.println将获取的内容打印在控制台上
		System.out.println(resp.getText());
		// 断言

//		Assert.assertEquals(resp.getText(),
//				"<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<metacharset=\"ISO-8859-1\">\r\n"
//						+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
//						+ " <h1>success</h1>\r\n" + "</body>\r\n" + "</html>");
		Assert.assertEquals(resp.getText(),
				"<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "	<h1>fail</h1>\r\n"
						+ "</body>\r\n" + "</html>");
	}

}
