package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.ShoppingDAO;
import com.model.LikedProductsModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/myFavProdServlet")
public class MyFavProductsServlet extends HttpServlet{

		//private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Here invoke the custID from the LoginServlet
			HttpSession session = request.getSession();
			int custId = (Integer) session.getAttribute("customerId");
			
			/*
			 * method: Dao layer
			 * Description: sd.myFavProducts(custId) this method is getting the number of likes whose customer.
			 */
			ShoppingDAO sd= new ShoppingDAO();
			int likesCount = sd.myFavProducts(custId);
			
			//Here sending the number of likes to the frontend
			session.setAttribute("likesCount", likesCount);
			
			//getting the liked products
			ArrayList<LikedProductsModel> likedList = sd.getLikedProducts(custId);
			
			//sending the likeslist to frontend
			session.setAttribute("likedList", likedList);
			
			
			//Redirects to MyFavProducts.jsp page.
			request.getRequestDispatcher("/MyFavProducts.jsp").include(request, response);
		}
}
