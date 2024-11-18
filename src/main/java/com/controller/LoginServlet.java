package com.controller;


import java.io.IOException;
import java.util.ArrayList;

import com.dao.ShoppingDAO;
import com.model.LoginModel;
import com.model.ProductsModel;
import com.model.RegisterModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*
* Here reteving data from frontend.By the login.jsp form name tags.
*/
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		
		//Radio is came from the "radio" of the radio button
		String radio=request.getParameter("Radio");
		System.out.println(radio);
		
		
		String statusForCustomer="";
		String statusAdmin="";

		/*
		 * Method Name: Creating object for LoginMOdel or DTO (Data Transfer Object)
		* Description: Here setting the user data to the model.
		*/

		//Login model
		LoginModel lm = new LoginModel();
		lm.setUsername(username);
		lm.setPassword(password);

		/*
		 * Method Name:DAO(Data Access Object) layer.
		 * Here creating an object of DAO class and getting DAO layer properties.
		 * selectQuery(lm) In this method passing the model Object for only customer login then its shows user details.
		 * sd.adminQuery() in this method directly passing username & password checking user is there or not? .
		 * sd.getDataIntoCustomer(lm) This method for getting customer list of data .
		 * if it is customer then status is success then redirect to home.jsp whith the customer list.
		 * if it is admin then status is adminsuccess then redirect to admin.jsp.
		 * sd.getCustomerId(username) this sending the username and getting the customerId.
		 */
		ShoppingDAO sd = new ShoppingDAO();
		int customerId = sd.getCustomerId(username);
		
		String status = sd.selectQuery(lm);
		String adminStatus = sd.adminQuery(username, password);
		ArrayList<RegisterModel> customerData = sd.getDataIntoCustomer(lm);
		ArrayList<ProductsModel> productsData = sd.getProductsDataToAdmin();

		/*
		 * HttpSession allows us to set objects as attributes that can be retrieved in future requests.
		 * This method always returns a HttpSession object.
		 */
		HttpSession session =request.getSession();
		
		if(radio.equals("Customer")) {
			
			statusForCustomer = sd.selectQuery(lm);
		
			if (statusForCustomer.equals("success")) {
				
				// Its relocate the Home page
				session.setAttribute("customerData", customerData);
				session.setAttribute("productsData", productsData);
				session.setAttribute("name", sd.fname);
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
			} else {
				
				// Its relocate the Login page
				String res="Invalid Credentials";
				request.setAttribute("invalid", res);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			
		}
		
		else if(radio.equals("Admin")){
					
			statusAdmin = sd.adminQuery(username, password);
					
					if (statusAdmin.equals("adminSuccess")) {
						
						// Its relocate the Admin Home page
						session.setAttribute("name", sd.fname);
						RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
						rd.include(request, response);
					} else {
						
						// Its relocate the Login page
						request.setAttribute("invalid", "*Invalid Credentials");
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.include(request, response);
					}
					
				}
		
		
		//--------------------------------------------------------------------------
		
//		if(status.equals("success")) {
//			session.setAttribute("customerData", customerData);
//			session.setAttribute("productsData", productsData);
//			session.setAttribute("name", sd.fname);
//			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//			rd.include(request, response);
//		}else if(adminStatus.equals("adminSuccess")) {
//			RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
//			rd.include(request, response);
//		}
//		else {
//			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//			rd.include(request, response);
//		}
		
		//------------------------------------------------------------------------
		
		
		//customerId is forward to Action servlet here
		session.setAttribute("customerId", customerId);
		RequestDispatcher rd =  ((ServletRequest) session).getRequestDispatcher("/actionServlet");
		rd.forward(request, response);
		
		//customerData is forward to editCustProfile servlet here
		session.setAttribute("customerData", customerData);
		RequestDispatcher rd1 = ((ServletRequest) session).getRequestDispatcher("/editProfileServlet");
		rd1.forward(request, response);
		
		//CustomerId forward to MyFavProductServlet here
		RequestDispatcher rd2 = ((ServletRequest) session).getRequestDispatcher("/myFavProdServlet");
		rd2.forward(request, response);

	}

}


