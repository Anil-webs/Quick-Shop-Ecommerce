package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.ShoppingDAO;
import com.model.ActionModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/actionServlet")
public class ActionServlet extends HttpServlet{
	//private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String productIdParam = request.getParameter("productId");
			int productId = Integer.parseInt(productIdParam);
			String action = request.getParameter("action");
			
			/*
			 * Description: customerId getting from the LoginServlet.java by using forward().
			 */
			HttpSession session = request.getSession();
			int customerId =  (Integer) session.getAttribute("customerId");

			/*
			 * Method:Model
			 */
			 ActionModel am = new ActionModel();
			 am.setProductId(productId);
			 am.setCustomerId(customerId);
			 am.setLikesDislikes(action);
			
			 
			/*
			 * Method: DAO(Data Access Object) layer.
			 * Description: Here creating an object of DAO class and getting DAO layer properties.
			 * sd.action(action,productId,customerId) sending the arguments.
			 */
			ShoppingDAO sd = new ShoppingDAO();
			String status = sd.actionUpadte(am);
			/*
			 * sd.actionQuery(am) this method customer likes/dislikes new product or new customer enters to like likes/dislikes products 
			 * then if status is success inside the if conditon this methods will calls.
			 */
			if(status.equals("success")) {
				sd.actionQuery(am);
			}

			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
			
		}
}
