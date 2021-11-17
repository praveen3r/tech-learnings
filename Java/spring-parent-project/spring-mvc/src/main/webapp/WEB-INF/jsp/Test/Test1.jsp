<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.error {
color:red;
font-size:14px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<form:form commandName="testPrav" action="create.html">
<table>
<p>${exp}</p>
<tr><td>firstName: <form:input path="firstName" type="text" name="firstName"/>
<form:errors path="firstName" cssClass="error"></form:errors>
<tr><td>lastName: <form:input path="lastName" type="text" name="lastName"/>
<form:errors path="lastName" cssClass="error"></form:errors>
<tr><td>emailId: <form:input path="emailId" type="text" name="emailId"/>
<form:errors path="emailId" cssClass="error"></form:errors>
<tr><td>address: <form:input path="address" type="text" name="address"/>
<form:errors path="address" cssClass="error"></form:errors>
<tr><td><input type="submit" value="create">
</table>
</form:form>
</body>
</html>