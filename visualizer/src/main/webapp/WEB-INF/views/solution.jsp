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
	
		<h1>áDÁM része</h1>
		
		<form:form method="POST" modelAttribute="solutionForm" action="">
		<table>
			<tr>
				<form:checkbox path="algorithms" value="BackTrackSimple" />Backtrack<br/>
				<form:checkbox path="algorithms" value="BackTrackCircle" />Backtrack with cycle detection<br/>
				<form:checkbox path="algorithms" value="BackTrackPathLengthLimitation" />Backtrack with pathlength limitation<br/>
				<form:checkbox path="algorithms" value="BackTrackOptimal" />Backtrack branch and bound<br/>
				<form:checkbox path="algorithms" value="BreadthFirst" />Breadth-first<br/>
				<form:checkbox path="algorithms" value="DepthFirst" />Depth-first<br/>
				<form:checkbox path="algorithms" value="Optimal" />Optimal<br/>
				<form:checkbox path="algorithms" value="BestFirst" />Best-first<br/>
				<form:checkbox path="algorithms" value="A" />A<br/>
			</tr>
			<tr>
				<td>Heurisztika :</td>
				<td><form:textarea path="heuristic" rows="5" cols="30" /></td>
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