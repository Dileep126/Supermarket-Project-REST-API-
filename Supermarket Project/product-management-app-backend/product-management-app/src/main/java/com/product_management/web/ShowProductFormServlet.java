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


@WebServlet("/show-product-form")
public class ShowProductFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(ShowProductFormServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			HttpSession session= request.getSession(false);
			if(session!=null) {
				logger.info("Rendering Add Tax Master Form");
				request.getRequestDispatcher("WEB-INF/views/add-product.jsp")
															.forward(request, response);
			}else {
				request.getRequestDispatcher("login.html").include(request, response);;
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
