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

@WebServlet("/updateServlet")
public class UpadateServlet extends HttpServlet{
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Here reteving data from frontend.By the update.jsp form name tags.
		 */
		int productId = Integer.parseInt(request.getParameter("productid"));
		String productName = request.getParameter("ProductName");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Double price = Double.parseDouble(request.getParameter("price"));
		
		/*
		 * Method Name: Creating object for ProductsModel or DTO (Data Transfer Object)
		 * Description: Here setting the udated products data to the model.
		 */
		ProductsModel pm = new ProductsModel();
		pm.setProductId(productId);
		pm.setProductName(productName);
		pm.setProductQuantity(quantity);
		pm.setProductPrice(price);
		
		/*
		 * Method Name:DAO(Data Access Object) layer.
		 * Description:Here creating an object of DAO class and getting DAO layer properties.
		 * sd.updateProductsQuery(pm) In this method passing the model Object.with updated product details
		 * sd.getProductsDataToAdmin(); this method getting the data with updated products.
		 */
		ShoppingDAO sd = new ShoppingDAO();
		sd.updateProductsQuery(pm);
		ArrayList<ProductsModel> productsData = sd.getProductsDataToAdmin();
		
		/*
		 * HttpSession allows us to set objects as attributes that can be retrieved in future requests.
		 * This method always returns a HttpSession object.
		 * setAttribute() data will sends to front jsp page.
		 */
		HttpSession session = request.getSession();
		session.setAttribute("productsData", productsData);
		
		/*
		 * Method Name:	getRequestDispatcher("productsList.jsp")
		 * Description: when admin clicks update button it call updateServlet fetch the details and redirect towards productsList page.
		 */
		RequestDispatcher rd = request.getRequestDispatcher("productsList.jsp");
		rd.include(request, response);
		
	}
}
