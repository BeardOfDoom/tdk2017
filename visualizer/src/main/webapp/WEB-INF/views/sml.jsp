<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="hu">

<head>

	<c:url value="/resources/js/jquery-3.1.1.min.js" var="jQuery" />
	<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<c:url value="/resources/css/pagestyle.css" var="pageStyle" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>

	<meta charset="UTF-8">
	<title><spring:message code="title.new.graph" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container myContainer">
	<div class="row">
	
		<h1>Ládzi része</h1>
		
		<form:form method="POST" modelAttribute="smlForm" action="">
		<table>
			<tr>
				<td>Input :</td>
				<td><form:textarea path="text" rows="5" cols="30" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
		</form:form>
		
	</div>
</div>

</body>

</html>