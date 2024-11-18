package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.ShoppingDAO;
import com.dao.ShoppingInterface;
import com.model.ProductsModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/products")
public class productsServlet extends HttpServlet {
		//private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*
 *  Here reteving data from frontend.By the productAdd.jsp form name tags.
 *  This productAdd.jsp form action is calling productservlet.
 */
			Integer productId = Integer.parseInt(request.getParameter("id"));
			System.out.println(productId);
			String productName = request.getParameter("pName");
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			Double price = Double.parseDouble(request.getParameter("price"));
			
			/*
			 * Method Name: Creating object for productsModel or DTO (Data Transfer Object)
			* Description: Here setting the prduct data to the model.
			*/
			ProductsModel pm = new ProductsModel();
			pm.setProductId(productId);
			pm.setProductName(productName);
			pm.setProductQuantity(quantity);
			pm.setProductPrice(price);
			
			/*
			* Method Name:DAO(Data Access Object) layer.
			* Description:Here creating an object of DAO class and getting DAO layer properties.
			* sd.getProductsDataToAdmin() this method getting the products list with new added product to admin.
			*/
			ShoppingInterface sd = new ShoppingDAO();
			sd.AddProductsQuery(pm);
			ArrayList<ProductsModel> productsData = sd.getProductsDataToAdmin();
			
			/*
			 * HttpSession allows us to set objects as attributes that can be retrieved in future requests.
			 * This method always returns a HttpSession object.
			 * setAttribute() data will sends to front jsp page.
			 */
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
