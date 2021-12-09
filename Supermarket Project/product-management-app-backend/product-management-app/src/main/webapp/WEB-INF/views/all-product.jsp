<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Product List </h2>

		<table class="table">
			<thead>
				<tr>					
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Type</th>	
					<th>Brand</th>
					<th>Image</th>	
					<th>Product Details</th>												
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
			    <%-- <c:forEach> is a JSTL core tag that iterates through a list --%>
				<%-- we are able to iterate through an ArrayList
				     using JSTL tag without writing any Java code --%>
				
				<c:forEach var="t" items="${productMasterList}">
					<tr class="success">						
						<td>${t.productMasterId}</td>
						<td>${t.productName}</td>
						<td>${t.category}</td>
						<td>${t.type}</td>	
						<td>${t.brand}</td>		
						<td>${t.image}</td>	
						<td>${t.productDetails}</td>														
						<td><a href="pre-edit-tax?tc=${t.productMasterId}">edit</a></td>
						<td><a href="delete-tax?tc=${t.productMasterId}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>