<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
		<h1>Fájl feltöltés</h1>
		
		<div>
			<h2>Információk</h2>
			<p>A feltölteni kívnát fájl kiterjesztése <b>.txt</b> kell hogy legyen, és a mérete <b>maximum 5MB</b> lehet!</p>
		</div>
		
		<c:choose>
			<c:when test="${response != null}">
				<c:choose>
					<c:when test="${errorMessage == null}">
						<div class="panel panel-success response">
							<div class="panel-heading">Sikeres feltöltés!</div>
							<div class="panel-body">
								<p>Folyamat azonosító: ${processIdentifier}</p>
								<p><a href="${pageContext.request.contextPath}/graph/view/${processIdentifier}">Tovább a gráfhoz</a></p>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="panel panel-danger response">
							<div class="panel-heading">Sikertelen feltöltés!</div>
							<div class="panel-body"><spring:message code="${errorMessage}" /></div>
						</div>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>
		
		<div class="form-div">
			<form method="POST" action="./upload" enctype="multipart/form-data">
				<p><input class="file" type="file" name="file" data-show-preview="false" /></p>
				<p><button class="btn btn-primary" type="submit">Feltöltés</button></p>
			</form>
		</div>
		
	</div>
</div>

</body>

</html>