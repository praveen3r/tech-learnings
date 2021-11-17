<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<P>Enter card no</p>

	<form action="checkEligibility" method="post">
		<input type="text" id="cardNo" name="cardNo"><br> <input
			type="submit" value="Submit">
	</form>
</body>
</html>