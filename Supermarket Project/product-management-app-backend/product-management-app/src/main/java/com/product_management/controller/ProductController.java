package com.product_management.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.product_management.bean.ProductDetails;
import com.product_management.bean.UserCredential;
import com.product_management.bean.ProductMaster;
import com.product_management.exception.ProductException;
import com.product_management.service.ProductMasterService;
import com.product_management.service.ProductMasterServiceImpl;

@Path("/products")
public class ProductController {
	
	ProductMasterService service=new ProductMasterServiceImpl();
	private Logger logger= Logger.getLogger(ProductController.class);
	// http://localhost:8081/product-management-app/rest/products
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductsAsJson() throws ProductException {
        List<ProductMaster> productList = service.getAllProductMaster();       
        return Response.ok(productList).build();
    }
	
	// http://localhost:8081/product-management-app/rest/products/1001	
	@GET
    @Path("/{productMasterId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("productMasterId") Long productMasterId) throws ProductException {
		ProductMaster productMaster=service.getProductMasterById(productMasterId);
        return Response.ok(productMaster).build();
    }
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(ProductMaster product) throws ProductException {
        String result= service.addProductMaster(product);
        return Response.ok(product).build();
    }
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(ProductMaster productMaster) throws ProductException {
	    String result= service.updateProductMaster(productMaster);
	    return Response.ok(productMaster).build();
	}
	
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProductMaster(ProductMaster productMaster) throws ProductException {
    	Long product_id=productMaster.getProductMasterId();
    	String result= service.deleteProductMaster(product_id);
    	return Response.ok(result).build();
    }
    

}
