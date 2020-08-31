<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Customer Form</title>

<link type="text/css" rel="sytlesheet" href="${pageContext.request.contextPath}/css_styling/add-customer-style.css" />

</head>
<body>

	<div id="wrapper" >
		<div id="header" >
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
		<div id="container">
		<h2>Add Customer</h2>	
		<form:form action="saveCustomerData" modelAttribute="customerData" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save" class="save" ></td>
					</tr>
				</tbody>
			</table>
		
		<div style="clear; both;" ></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
		
		</form:form>
		
		</div>

</body>
</html>