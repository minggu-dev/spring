<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
<h1>상세보기</h1>
<table border="1">
 <tr>
   <th>상품코드</th>
   <td><input type="text" name="code" value="${product.code}" disabled></td>
 </tr>
  <tr>
   <th>상품이름</th>
   <td><input type="text" name="name" value="${product.name}" disabled></td>
 </tr>
  <tr>
   <th>상품가격</th>
   <td><input type="number" name="price" value="${product.price}" disabled></td>
 </tr>
  <tr>
   <th>상품설명</th>
   <td><textarea name="detail" rows="10" cols="20" disabled>${product.detail}</textarea></td>
 </tr>
 <tr>
   <th colspan="2">
	<a href="start.kosta">홈으로</a>
   </th>
 </tr>
</table>
</body>
</html>





