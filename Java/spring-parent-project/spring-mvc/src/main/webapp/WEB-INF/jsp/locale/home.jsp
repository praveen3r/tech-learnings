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
	<form:form>
		<table>
			<tr>
				<td><spring:message code="label.firstName"/> <input type="text" id="firstName"
					name="firstName" value="" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="label.lastName"/> <input type="text" id="lastName" name="lastName"
					value="" />
				</td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>