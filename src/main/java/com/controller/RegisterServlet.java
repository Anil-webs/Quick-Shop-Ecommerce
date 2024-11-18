package com.controller;


import java.io.IOException;

import com.dao.ShoppingDAO;
import com.dao.ShoppingInterface;
import com.model.RegisterModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*
 * Here reteving data from frontend.By the Register.jsp form name tags.
 */		
		String firstname = request.getParameter("firstname");
		System.out.println(firstname);
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		
/*
 * Method Name: Creating object for RegisterMOdel or DTO (Data Transfer Object)
 * Description: Here setting the user data to the model.
 */
		RegisterModel rm = new RegisterModel();
		//rm.setCust_SNo(cust_SNo);
		rm.setFirstname(firstname);
		rm.setUsername(username);
		rm.setPassword(password);
		

/*
 * Method Name:DAO(Data Access Object) layer.
 * Description:Here creating an object of DAO class and getting DAO layer properties.
 * insertUpdate(rm) In this method passing the model Object.
 */
		ShoppingInterface sd = new ShoppingDAO();
		sd.insertUpdate(rm);

/*
 * Method Name:	getRequestDispatcher("login.jsp")
 * Description: when user fill the register form fetch the details and redirect towards login page.
 */
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	}

}
