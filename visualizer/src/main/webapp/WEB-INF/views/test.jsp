<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
</head>
<body>
<h1><spring:message code="message.test" /></h1>

<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/>
    <input type="submit" value="Submit" />
</form>

<c:choose>
<c:when test="${errorMessage == null}">
    <p><a href="./process/${processIdentifier}">${processIdentifier}</a></p>
</c:when>
<c:otherwise>
    <p><spring:message code="${errorMessage}" /></p>
</c:otherwise>
</c:choose>
</body>
</html>