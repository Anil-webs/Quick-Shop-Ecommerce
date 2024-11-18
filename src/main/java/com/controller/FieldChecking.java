package com.controller;


import java.io.IOException;

import com.dao.ShoppingDAO;
import com.model.LoginModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/fieldCheck")
public class FieldChecking extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  Here reteving data from frontend.By the Register.jsp form name tags. 
		 */
		String username = request.getParameter("username");

		
		/*
		 * Method Name:DAO(Data Access Object) layer.
		 * Description:Here creating an object of DAO class and getting DAO layer properties.
		 * sd.fieldChecksAdmin(username),sd.fieldChecksUser(username) this methods checks that username is their or not ?.
		 */
		ShoppingDAO sd = new ShoppingDAO();
		String StatusChecksAdmin = sd.fieldChecksAdmin(username);
		String StatusChecksUser = sd.fieldChecksUser(username);
		
		if(StatusChecksAdmin.equals("fieldAdminSuccess") && StatusChecksUser.equals("fieldUserSuccess")) {
			String info = "You can go forhead this username";
			response.setContentType("text/plain");
			response.getWriter().write(info);
		}else {
			String info = "This username is already exists!!!";
			response.setContentType("text/plain");
			response.getWriter().write(info);
		}
	}

}
