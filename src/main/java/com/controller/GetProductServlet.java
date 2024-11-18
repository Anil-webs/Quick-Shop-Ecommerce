package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.ShoppingDAO;
import com.model.ProductsModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/getProducts")
public class GetProductServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		* Method Name:DAO(Data Access Object) layer.
		* Description:Here creating an object of DAO class and getting DAO layer properties.
		* sd.getProductsDataToAdmin() this method getting the products list to when admin enter the admin page.
		*/
		ShoppingDAO sd = new ShoppingDAO();
		ArrayList<ProductsModel> productsData = sd.getProductsDataToAdmin();
		System.out.println("productsData size : "+productsData.size());
		HttpSession session =request.getSession();
		session.setAttribute("productsData", productsData);
		
		/*
		* Method Name:	getRequestDispatcher("productsList.jsp")
		* Description: when admin hit the productsList.jsp page its shows the products list.
		*/
		RequestDispatcher rd = request.getRequestDispatcher("productsList.jsp");
		rd.include(request, response);
	}
}
