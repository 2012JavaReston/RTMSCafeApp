package com.cafe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe.model.User;

public class LoginController {
	
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			
			getLogin(req, resp);
			
			if(req.getParameter("username").equals("Admin") && req.getParameter("password").equals("1234")) {
					HttpSession sesh = req.getSession();
					sesh.setAttribute("MasterAccess", true);
					
					resp.sendRedirect("http://localhost:8080/CafeMenu/menu");
			} else {
				resp.setStatus(403);
				resp.sendRedirect("http://localhost:8080/CafeMenu/menu/login");
			}
			
		} else {
			resp.setStatus(405);
			resp.sendRedirect("http://localhost:8080/CafeMenu/menu/login");
		}
		
	}

	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getSession().invalidate();
		resp.sendRedirect("http://localhost:8080/CafeMenu/menu/login");
	}
	
	public static void getLandingPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher redis = req.getRequestDispatcher("/login.html");	
		redis.forward(req, resp);		
	}
	
	public static void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); 
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		session.setAttribute("username", "Admin");
		session.setAttribute("password", "1234");
		User u = new User(username,password);
		session.setAttribute("user", u);
		
		System.out.println(u);
		
		//RequestDispatcher redis = request.getRequestDispatcher("/SuperSecretSecretiveServlet");
		
		//redis.forward(request, response);
	}


}
