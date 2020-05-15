<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	width: 200px;
}
table,tr,td,th{
	border-collapse : collapse;
	border: 1px solid;
}
</style>
</head>
<body>
	<div>
		<form action="login.mino" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" placeholder="id를 입력해주세요."></td>
				</tr>
				<tr>
					<th>PWD</th>
					<td><input type="password" name="pwd" placeholder="비밀번호를 입력해주세요."></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right"><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>