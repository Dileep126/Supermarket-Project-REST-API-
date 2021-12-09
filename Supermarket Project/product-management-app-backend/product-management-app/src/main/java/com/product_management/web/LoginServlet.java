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

import com.product_management.service.UserCredentialService;
import com.product_management.service.UserCredentialServiceImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserCredentialService userCredentialService= new UserCredentialServiceImpl();
	private Logger logger= Logger.getLogger(LoginServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			String username = request.getParameter("username");
			String password= request.getParameter("password");
			if(username.length()==0|| password.length()==0) {
				throw new Exception("Username or password cannot be blank");
			}
			if(userCredentialService.isValidCredential(username, password)) {
				//Returns the current session associated with this request,or if the request does 
				//not have a session, creates one.
				HttpSession session= request.getSession();
				session.setAttribute("username", username);
				logger.info(username +" logged in");
				request.getRequestDispatcher("WEB-INF/views/menu.jsp").forward(request, response);
			}else {
				out.println("<h2>Invalid Credentials</h2>");
				request.getRequestDispatcher("login.html").include(request, response);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
