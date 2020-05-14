<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 상세보기</h1>
	<div>
		<table>
			<tr><td>제목 : </td><td>${board.subject}</td></tr>
			<tr><td>내용 : </td><td>${board.content}</td></tr>
		</table>
	</div>
	<a href="list.kosta">게시판 가기</a>
</body>
</html>