<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List customers</title>

<link type="text/css" rel="stylesheet" 
	  href = "${pageContext.request.contextPath}/css_styling/style.css" />
	  

</head>
<body>

	<div id="wrapper" >
		<div id="header" >
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Customer" onClick="window.location.href='addCustomerForm'" />
		
			<table>
				<tr>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="cust" items="${customerList}">
					<tr>
						<td>${cust.id}</td>
						<td>${cust.firstName}</td>
						<td>${cust.lastName}</td>
						<td>${cust.email}</td>
					</tr>
				
				</c:forEach>

			</table>
		
		</div>
	</div>

</body>
</html>