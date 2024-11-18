package com.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		* HttpSession allows us to set objects as attributes that can be retrieved in future requests.
		* This method always returns a HttpSession object.
		* invalidate() in order to invalidate (make the session inactive).
		* when sessionis out its redirect to login page.
		*/
		 // Invalidate the session if exists
        HttpSession session = request.getSession(false); // Get the existing session, do not create a new one
        if (session != null) {
            session.invalidate();
        }
		
		Cookie[] cookies =request.getCookies();
		if(cookies != null) {
			for(Cookie cookie :cookies) {
				cookie.setValue("");
				cookie.setPath("/"); // Set the path as per your application's context path
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		
		// Redirect to login page after logout
		//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		// Redirect to login page after logout
        response.sendRedirect("login.jsp");
		//rd.include(request, response);
		
		
	}
	
}
