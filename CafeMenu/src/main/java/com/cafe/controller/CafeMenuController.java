package com.cafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe.model.CafeMenu;
import com.cafe.service.CafeMenuService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CafeMenuController {

	private static CafeMenuService mService = new CafeMenuService();

	public static void createItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if(req.getMethod().equals("POST")) {
			ObjectMapper om = new ObjectMapper();
			
			CafeMenu cm = om.readValue(req.getReader(), com.cafe.model.CafeMenu.class);
					
			System.out.println(mService.createItem(cm));

			
			resp.setStatus(201); 
			
		} else {
			resp.setStatus(405);
		}

	}

	public static void updateItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		if(req.getMethod().equals("PUT")) {
			ObjectMapper om = new ObjectMapper();
			
			CafeMenu cm = om.readValue(req.getReader(), com.cafe.model.CafeMenu.class);
			
			mService.updateItem(cm);
			
			resp.setStatus(201);
			
		} else {
			resp.setStatus(405);
		}

	}

	public static void deleteItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if(req.getMethod().equals("DELETE")) {
			ObjectMapper om = new ObjectMapper();
			
			CafeMenu cm = om.readValue(req.getReader(), com.cafe.model.CafeMenu.class);
			
			mService.deleteItem(cm.getItemName());
			
			resp.setStatus(201); 
			
		} else {
			resp.setStatus(405);
		}

	}

	public static void getMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("GET")) {
			CafeMenu[] cm = null;
			
			resp.setContentType("application/json");
			
			cm = mService.getMenu();
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(cm)); 
		
			
		} else {
			resp.setStatus(405);
			
		}

	}
	
}
