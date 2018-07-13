package com.vance.scrm.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vance.scrm.po.Customer;
import com.vance.scrm.po.LoginStatus;
import com.vance.scrm.service.ICustomerService;
import com.vance.scrm.service.impl.CustomerServiceImpl;
import com.vance.scrm.util.JsonUtil;
import com.vance.scrm.util.MsgSender;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICustomerService service = new CustomerServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. receive the parameters of request
		String customerName = request.getParameter("customerName");
		String customerPwd = request.getParameter("customerPwd");
		
		// 2. type mapping
		
		// 3. Validation
		
		// 4. make an encapsulation to project object
		
		// 5. call service method
		
		// 6. receive the data from service method
		Customer cus = service.login(customerName, customerPwd);
		LoginStatus status = new LoginStatus(customerName, "undetermined", new Date());
		if(cus == null) {
			status.setLoginStatus("fail");
			MsgSender.sendMsg(JsonUtil.objectToJson(status));
			response.sendRedirect("fail.html");
		}else {
			status.setLoginStatus("success");
			MsgSender.sendMsg(JsonUtil.objectToJson(status));
			
			// 7. set the data to reqeust or session or application
			request.getSession().setAttribute(cus.getCustomerId(), cus);
			// 8. redirect or dispacher
			response.sendRedirect("succ.html");
		}
	}

}
