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
import jakarta.servlet.jsp.PageContext;

@WebServlet("/deleteProduct")
public class DeleteProductsServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Here reteving productId with individually from the productList.jsp page anchor tag calls the deleteServlet.
		 */
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("delete");
		
		/*
		 * Method Name:DAO(Data Access Object) layer.
		 * Description:Here creating an object of DAO class and getting DAO layer properties.
		 * sd.deleteProductQuery(productId) this method passing productId.
		 * sd.getProductsDataToAdmin() this after deleting data showing with updated data.
		 */
		ShoppingDAO sd = new ShoppingDAO();
		sd.deleteProductQuery(productId);
		ArrayList<ProductsModel> productsData = sd.getProductsDataToAdmin();
		HttpSession session =request.getSession();
		session.setAttribute("productsData", productsData);
		
		RequestDispatcher rd = request.getRequestDispatcher("productsList.jsp"); 
		rd.include(request, response);
	}

}
