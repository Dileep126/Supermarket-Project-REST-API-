package com.product_management.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.product_management.bean.ProductMaster;
import com.product_management.service.ProductMasterService;
import com.product_management.service.ProductMasterServiceImpl;

@WebServlet("/all-product")
public class AllProductMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMasterService productMasterService= new ProductMasterServiceImpl();
	private Logger logger= Logger.getLogger(AllProductMasterServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			HttpSession session= request.getSession(false);
			if(session!=null) {
				//connect to database and fetch all records in List of TaxMaster
				List<ProductMaster> productMasterList= productMasterService.getAllProductMaster();
				//make this list available to JSP, add taxMasterList as an attribute to request object
				request.setAttribute("productMasterList", productMasterList);
				logger.info("Rendering All Product Master Details");
				request.getRequestDispatcher("WEB-INF/views/all-product.jsp")
															.forward(request, response);
			}else {
				request.getRequestDispatcher("login.html").include(request, response);;
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
