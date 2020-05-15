<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
<style>
table{
	width: 100%;
}

table,tr,td,th{
	border-collapse: collapse;
}
.header{
	height : 150px;
	border: 1px solid;
}

.left{
	width : 25%;
	height : 600px;
	display : inline-block;
	border: 1px solid;
	margin-right: auto;
}
.center{
	width : 75%;
	height: 600px;
	display : inline-block;
	border: 1px solid;
	margin-left: auto;
}

.footer{
	height: 100px;
	border: 1px solid;
}
</style>
</head>
<body>
<table>
	<tr class="header">
		<th colspan="2"><jsp:include page="header.jsp"/></th>
	</tr>
	
	<tr>
		<td class="left">
			<c:choose>
				<c:when test="${sessionScope.id == null}">
					<iframe src="loginForm.mino" width="100%" height="580px"></iframe>
				</c:when>
				<c:otherwise>
					<iframe src="login.mino" width="100%" height="580px"></iframe>
				</c:otherwise>
			</c:choose>
		</td>
		
		<td class="center">
			<c:choose>
				<c:when test="${sessionScope.id == null}">
					<div>
						로그인 후 이용해 주세요.
					</div>
				</c:when>
				<c:otherwise>
					<iframe src="start.kosta" width="100%" height="580px"></iframe>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr class="footer">
		<td colspan="2"><jsp:include page="footer.jsp"/></td>
	</tr>
</table>
</body>
</html>