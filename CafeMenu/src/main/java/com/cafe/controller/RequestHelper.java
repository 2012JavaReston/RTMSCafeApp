package com.cafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String endpoint = req.getRequestURI();
		
		switch(endpoint) {
			case "/CafeMenu/menu/item":
				switch(req.getMethod()) {
					case "POST":
						CafeMenuController.createItem(req, resp);
						break;
					case "GET":
						CafeMenuController.getMenu(req, resp);
						break;
					case "DELETE":
						CafeMenuController.deleteItem(req, resp);
						break;
					case "PUT":
						CafeMenuController.updateItem(req, resp);
						break;
				}
				break;
				
			case "/CafeMenu/menu/login":
				switch(req.getMethod()) {
					case "POST":
						LoginController.login(req, resp);
						break;
					case "DELETE":
						LoginController.logout(req, resp);
						break;
				}
				break;
			default:
				resp.sendRedirect("http://localhost:8080/CafeMenu/menu/login");
		}

	}

}
