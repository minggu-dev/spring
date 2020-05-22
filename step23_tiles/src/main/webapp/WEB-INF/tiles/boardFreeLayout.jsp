<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	header{
		width:800px;
		height: 400px;
		background-color: aqua;
	}
	
	footer{
		width:800px;
		height: 400px;
		background-color: maroon;
	}
</style>
</head>
<body>
	<h1>boardFreeLayout.jsp입니다...</h1>
	
	<header>
		<tiles:insertAttribute name="header"/>
	</header>
	
	<footer>
		<tiles:insertAttribute name="content"/>
	</footer>
</body>
</html>