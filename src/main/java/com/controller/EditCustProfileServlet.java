package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.ShoppingDAO;
import com.model.LoginModel;
import com.model.RegisterModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/editProfileServlet")
public class EditCustProfileServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Here invoke the values from frontend
		 */
		String firstName = request.getParameter("fname");
		String password = request.getParameter("psw");
		String userName = request.getParameter("uname");
		
		/*
		 * Method: Model
		 * Description: Here setting the updated values in the model.
		 */
		RegisterModel rm = new RegisterModel();
		rm.setFirstname(firstName);
		rm.setPassword(password);
		rm.setUsername(userName);
		
		/*
		 * 
		 */
		HttpSession session = request.getSession();
		/*
		 * Method: DAO layer
		 * Description:
		 */
		 ShoppingDAO da = new ShoppingDAO();
		 da.editCustProfile(rm);
		//for getting updated customerValues
		 ArrayList<RegisterModel> updatedCustomerData=da.getUpdatedCustList(userName);
		 System.out.println(updatedCustomerData);
		 
		 	/*
			 * Description: customerData getting from the LoginServlet.java by using forward().
			 * and sending data to editCustPofile.jsp page.
			 */
			ArrayList<RegisterModel> customerData =   (ArrayList<RegisterModel>) session.getAttribute("customerData");
			session.setAttribute("customerData", customerData);
			
		 //Redirect page
		 session.setAttribute("customerData", updatedCustomerData);
		 String FirstName=request.getParameter("fname");
		 session.setAttribute("name",FirstName);
		 request.getRequestDispatcher("/home.jsp").include(request, response);
		 
	}
}
