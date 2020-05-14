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
		width: 50%;
	}
</style>

</head>
<body>
<h1>게시물 등록하기</h1>
<div>
	<form action="insert.kosta" method="post">
		번호 &nbsp;&nbsp;&nbsp;: <input type="number" name="no"><br>
		제목 &nbsp;&nbsp;&nbsp;: <input type="text" name="subject"><br>
		내용 &nbsp;&nbsp;&nbsp;: <input type="text" name="content"><br>
		날짜 &nbsp;&nbsp;&nbsp;: <input type="text" name="date"><br>
		작성자 : <input type="text" name="writer"><br>
		<input type="submit" value="등록">
	</form>
</div>
</body>
</html>