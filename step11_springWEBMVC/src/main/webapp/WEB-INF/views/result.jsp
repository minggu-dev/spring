<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과화면</h1>
	<h3>
	메시지 : ${message}<br>
	아이디 : ${id}
	</h3>
	
	<hr>
	메시지 : ${msg} <br>
	
	<fieldset>
		<legend>취미들 : </legend>
		<c:forEach items="${hobbys}" var="h">
			<input type="radio" name="hobby" value="${h}">${h}<br>
		</c:forEach>
	</fieldset>
</body>
</html>