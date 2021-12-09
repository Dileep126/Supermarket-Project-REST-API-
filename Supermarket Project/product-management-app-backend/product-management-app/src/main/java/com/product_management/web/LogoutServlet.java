package com.product_management.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LogoutServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			//If Session object is existing, the method returns its id else returns false
			HttpSession session= request.getSession(false);
			if(session !=null) {
				String username= (String) session.getAttribute("username");
				//optional statement
				session.removeAttribute("username");
				//removes session object
				session.invalidate();
				logger.info(username+ " logged out");
				out.println(username+" has logged out");				
			}else {
				out.println("You have already logged out");
			}
			request.getRequestDispatcher("login.html").include(request, response);
		}catch(Exception e) {
			logger.error(e.getMessage(), e);			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
