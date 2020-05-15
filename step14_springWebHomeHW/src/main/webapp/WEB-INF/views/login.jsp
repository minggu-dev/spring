<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
	text-align: center;
}
a{
	text-decoration: none;
}
</style>
</head>
<body>
	<div>
		<br>
		<br>
		<br>
		<br>
		${sessionScope.id}님 로그인 중<br>
		<a href="logout.mino">로그아웃</a>
	</div>
</body>
</html>