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
	<form:form commandName="userVO" action="/spring-mvc/userValidation/add" method="POST">
		<form:errors path="*"/>
		<table>
			<tr>
				<td>firstName: <form:input path="firstName" type="text"
						name="firstName" /> </td></tr>
			<tr>
				<td>lastName: <form:input path="lastName" type="text"
						name="lastName" /> </td></tr>
			<tr>
				<td>emailId: <form:input path="emailId" type="text"
						name="emailId" /> </td></tr>
			<tr>
				<td>DOB: <input type="text" id="dob" name="dob"
					value="${userVO.dob}" />
				</td>
			</tr>
			<tr>
				<td>phoneNo: <input type="text" id="dob" name="phoneNo"
					value="${userVO.phoneNo}" />
				</td>
			</tr><tr>
				<td><input type="submit" value="create"></td></tr>
		</table>
	</form:form>
</body>
</html>