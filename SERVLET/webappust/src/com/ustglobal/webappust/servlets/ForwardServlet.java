package com.ustglobal.webappust.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		
		
		Object obj = new Object();
		req.setAttribute("obj", obj);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/date");
		
		
		dispatcher.forward(req, resp);
	}
}
