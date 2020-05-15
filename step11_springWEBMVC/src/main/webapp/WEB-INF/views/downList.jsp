<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a{text-decoration: none;}
</style>
</head>
<body>
<h1>파일 List</h1>
<ul>
	<c:choose>
		<c:when test="${empty fileNames}">
			<li>파일이 존재하지 않습니다..</li>
		</c:when>
		<c:otherwise>
			<c:forEach items="${fileNames}" var="file">
				<li><a href="down.do?fname=${file}">${file}</a></li>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</ul>
</body>
</html>