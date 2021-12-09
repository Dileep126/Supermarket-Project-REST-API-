<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
	body {
		background-color: #525252;
	}

	.centered-form {
		margin-top: 60px;
	}

	.centered-form .panel {
		background: rgba(255, 255, 255, 0.8);
		box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
	}
</style>

</head>
<body>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Enter New Product Details
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="http://localhost:8081/product-management-app/add-product">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="productCode" id="taxcode"
											class="form-control input-sm" placeholder="Enter Product Id">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="productName" id="taxname"
											class="form-control input-sm" placeholder="Enter Product Name">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="text" name="category" id="taxpercent"
									class="form-control input-sm" placeholder="Category">
							</div>								
							
							<div class="form-group">
								<input type="text" name="type" id="taxeffectivefrom"
									class="form-control input-sm" placeholder="Type">
							</div>		
							
							<div class="form-group">
								<input type="text" name="brand" id="taxeffectivefrom"
									class="form-control input-sm" placeholder="Brand">
							</div>	
							
							<div class="form-group">
								<input type="url" name="image" id="taxeffectivefrom"
									class="form-control input-sm" placeholder="Image">
							</div>						

							<input type="submit" value="Submit"
								class="btn btn-info btn-block">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>