<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
		<style type="text/css">
			.btn-glyphicon { padding:8px; background:#ffffff; margin-right:4px; }
			.icon-btn { padding: 1px 15px 3px 2px; border-radius:50px;}
		</style>
		<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	

		<h1 align="center"><font color="orange">Main Menu</font></h1>		
		
		<div align="center" class="container">
			<a class="btn icon-btn btn-primary" href="http://localhost:8081/product-management-app/all-product"><span class="glyphicon btn-glyphicon glyphicon-save img-circle text-muted"></span>List All Product Details</a>
			<a class="btn icon-btn btn-primary" href="http://localhost:8081/product-management-app/show-product-form"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-primary"></span>Add New Product</a>
			<a class="btn icon-btn btn-success" href="http://localhost:8081/product-management-app/logout"><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Logout</a>					
		</div>		

</body>
</html>