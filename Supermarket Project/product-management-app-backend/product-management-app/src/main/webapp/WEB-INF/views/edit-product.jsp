<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
							Enter New Tax Details
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="http://localhost:8081/supermarket-web-app/post-edit-tax">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="taxcode" id="taxcode"
											class="form-control input-sm" readonly="readonly" value="${taxMaster.taxCode}">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="taxname" id="taxname"
											class="form-control input-sm" readonly="readonly" value="${taxMaster.taxName }">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="text" name="taxpercent" id="taxpercent"
									class="form-control input-sm" placeholder="Enter tex percent" value="${taxMaster.taxPercent }">
							</div>								
							
							<div class="form-group">
								<input type="date" name="taxeffectivefrom" id="taxeffectivefrom"
									class="form-control input-sm"
											 placeholder="Enter tax effective from date(yyyy-mm-dd)" value="${taxMaster.taxEffectiveFrom}">
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