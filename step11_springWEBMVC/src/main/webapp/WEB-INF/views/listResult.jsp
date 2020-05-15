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
<h1> MemberList 등록 결과</h1>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>주소</th>
		<th>상태</th>
	</tr>
	<c:forEach items="${listDTO.list}" var="m" varStatus="state">
		<tr>
			<td>${state.count}</td>
			<td>${m.name}</td>
			<td>${m.age}</td>
			<td>${m.addr}</td>
			<td>${m.state}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>