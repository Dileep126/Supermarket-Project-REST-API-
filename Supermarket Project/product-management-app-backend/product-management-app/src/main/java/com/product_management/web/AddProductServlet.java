package com.product_management.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.product_management.bean.ProductDetails;
import com.product_management.bean.ProductMaster;
import com.product_management.service.ProductMasterService;
import com.product_management.service.ProductMasterServiceImpl;


@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMasterService productMasterService= new ProductMasterServiceImpl();
	private Logger logger= Logger.getLogger(AddProductServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			
			// getParameter() return type is always String, use wrapper class method to convert String to Long
			Long productCode= Long.parseLong(request.getParameter("taxcode"));
			String productName= request.getParameter("taxname");
			String category= request.getParameter("category");
			String type= request.getParameter("type");
			String brand = request.getParameter("brand");
			String image = request.getParameter("image");
			//String productDetails= request.getParameter("productDetails");
			
			//convert String to LocalDate
			//LocalDate taxEffectiveFrom= LocalDate.parse(request.getParameter("taxeffectivefrom"));
			ProductMaster productMaster= new ProductMaster(productCode,productName,category,type,brand,image,null);
			String message= productMasterService.addProductMaster(productMaster);
			logger.info(message);
			out.println("<h1>"+message+"</h1>");
			request.getRequestDispatcher("WEB-INF/views/menu.jsp").include(request, response);
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
