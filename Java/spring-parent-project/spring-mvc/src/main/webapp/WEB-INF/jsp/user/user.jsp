<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${msg}</p>
	<form:form commandName="userVO" action="/spring-mvc/user/add" method="POST">
		<table>
			<tr>
				<td>firstName: <form:input path="firstName" type="text" /> 
			<tr>
				<td>lastName: <form:input path="lastName" type="text"
						name="lastName" /> 
			<tr>
				<td>emailId: <form:input path="emailId" type="text"
						name="emailId" /> 
			<tr>
				<td>address: <form:input path="address" type="text"
						name="address" /> 
			<tr>
				<td><input type="submit" value="create">
		</table>
	</form:form>
</body>
</html>