<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${msg}</p>
	<form:form action="/spring-mvc/newUser/add" method="POST"
		modelAttribute="userVO">
		<%-- <table>
			<tr>
				<td>firstName: <form:input path="firstName" type="text"
						name="firstName" /> 
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
		</table> --%>
		<table>
			<tr>
				<td>firstName: <input type="text" id="firstName"
					name="firstName" value="${userVO.firstName}" />
				</td>
			</tr>
			<tr>
				<td>lastName: <input type="text" id="lastName" name="lastName"
					value="${userVO.lastName}" />
				</td>
			</tr>
			<tr>
				<td>address 1: <input type="text" id="lastName" name="address.addrLine1"
					value="${userVO.address.addrLine1}" />
				</td>
			</tr>
			<tr>
				<td>city: <input type="text" id="lastName" name="address.city"
					value="${userVO.address.city}" />
				</td>
			</tr>
			<tr>
				<td>mobile: <input type="text" id="mobile" name="mobileNo"
					value="${userVO.mobileNo}" />
				</td>
			</tr>
			<tr>
				<td>DOB: <input type="text" id="dob" name="dob"
					value="${userVO.dob}" />
				</td>
			</tr>
			<tr>
				<%-- <td>Sex: <form:select class="form-control form-control-select"
						path="sex" id="accountNumber" name="sex">
						<form:option value="" label="Select Sex" />
						<form:options items="${userVO.sexList}" />
					</form:select>
				</td> --%>
				<%-- <td>Sex: <form:select class="form-control form-control-select"
						path="sex" id="accountNumber" name="sex">
						<form:option value="" label="Select Sex" />
						<form:options items="${userVO.sexObjList}" itemLabel="desc" itemValue="code"/>
					</form:select>
				</td> --%>
				<td>Sex: <select name="sex">
				    	<option value="" label="Select Sex" />
				        <c:forEach items="${userVO.sexObjList}" var="sexObj">
				        	<option label="${sexObj.desc}" value="${sexObj.code}"/>
				        </c:forEach>
				    </select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="create"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>