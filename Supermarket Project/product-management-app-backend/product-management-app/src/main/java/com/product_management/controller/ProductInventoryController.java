package com.product_management.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.product_management.bean.ProductInventory;
import com.product_management.exception.ProductInventoryException;
import com.product_management.service.ProductInventoryService;
import com.product_management.service.ProductInventoryServiceImpl;

@Path("/productInventory")
public class ProductInventoryController {
	
	ProductInventoryService service=new ProductInventoryServiceImpl();
	// http://localhost:8081/product-management-app/rest/productInventory
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductsInventoryAsJson() throws ProductInventoryException {
        List<ProductInventory> productList = service.getAllProductInventory();       
        return Response.ok(productList).build();
    }
	
	// http://localhost:8081/product-management-app/rest/productInventory/9001
	@GET
    @Path("/{inventoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductInventory getProductInventory(@PathParam("inventoryId") Long inventoryId) throws ProductInventoryException {
        return service.getProductInventoryById(inventoryId);
    }
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addProductInventory(ProductInventory productInventory) throws ProductInventoryException {
        return service.addProductInventory(productInventory);
    }
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String updateProductInventory(ProductInventory productInventory) throws ProductInventoryException {
	    return service.updateProductInventory(productInventory);
	}
	
    @DELETE
    @Path("/{inventoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProductInventory(@PathParam("inventoryId") Long inventoryId) throws ProductInventoryException {
		return service.deleteProductInventory(inventoryId);
    }
    

}