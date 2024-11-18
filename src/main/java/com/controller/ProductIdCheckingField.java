package com.controller;

import java.io.IOException;

import com.dao.ShoppingDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productIdCheckingField")
public class ProductIdCheckingField extends HttpServlet{
	//private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*
			 *  Here reteving data from frontend.By the productsAdd.jsp form name tags. 
			 */
			Integer productId = Integer.parseInt(request.getParameter("id"));
			System.out.println("prdouctsid:"+ productId);

			
			/*
			 * Method Name:DAO(Data Access Object) layer.
			 * Description:Here creating an object of DAO class and getting DAO layer properties.
			 * sd.productIdChecksFields(productId) this methods checks that productId is their or not ?.
			 */
			ShoppingDAO sd = new ShoppingDAO();
			String status = sd.productIdChecksFields(productId);
			
			if(status.equals("success")) {
				String info = "You can go forhead this productId";
				response.setContentType("text/plain");
				response.getWriter().write(info);
			}else {
				String info = "This productId is already exists!!!";
				response.setContentType("text/plain");
				response.getWriter().write(info);
			}
			
		}

}
