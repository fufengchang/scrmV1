package com.vance.scrm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.getSession().setAttribute("listener", new SessionBindingListener());
//		getServletContext().setAttribute("hello", "attributelistener");
//		PrintWriter writer = response.getWriter();
//		writer.write("<h1>I am a test servlet......</h1>");
//		writer.close();
		
		request.setAttribute("username", "Curry");
		request.getSession().setAttribute("username", "kobe");
		
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		request.setAttribute("list", list);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("001", "Curry");
		map.put("002", "Kobe");
		map.put("003", "James");
		request.setAttribute("map", map);
		request.getRequestDispatcher("FirstJsp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
