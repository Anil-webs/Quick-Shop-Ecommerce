package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.ShoppingDAO;
import com.model.RegisterModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customerListServlet")
public class CustomerListServlet extends HttpServlet{
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
* Method Name:DAO(Data Access Object) layer.
* Description:Here creating an object of DAO class and getting DAO layer properties.
* sd.getCustomerDataToAdmin() this method getting the customer list.
*/
		ShoppingDAO sd = new ShoppingDAO();
		ArrayList<RegisterModel> customerDataToAdmin = sd.getCustomerDataToAdmin();
/*
* HttpSession allows us to set objects as attributes that can be retrieved in future requests.
* This method always returns a HttpSession object.
*/		
		HttpSession session =request.getSession();
		session.setAttribute("data", customerDataToAdmin);
		
/*
* Method Name:	getRequestDispatcher("customerList.jsp")
* Description: when admin hit the customerList.jsp page its shows the customer list.
*/	
		RequestDispatcher rd = request.getRequestDispatcher("customerList.jsp");
		rd.include(request, response);
	}

}
