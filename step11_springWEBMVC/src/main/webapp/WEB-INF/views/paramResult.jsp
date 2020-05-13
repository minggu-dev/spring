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
<h2>폼 결과 페이지</h2>

<h3>
이름   : ${m.name} <br>
나이   : ${m.age} <br>
아이디 : ${m.id} <br>
주소   : ${m.addr} <br>
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