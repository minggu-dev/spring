<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table{width: 100%;border:5px green solid;}
  td,th{text-align: center; border: 1px gray solid;}
  a{text-decoration: none;}
  div{text-align: center;}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script>
	$(function(){
		$('input[type=button]').click(function(){
			$('form').attr("action","del/" + $(this).attr("name"));
			$('form').submit();
		})
	})
</script>

</head>
<body>
  <div><h1>[ Product List Page ]</h1></div>
<table>
 <tr>
   <th>번호</th>
   <th>상품코드</th>
   <th>상품이름</th>
   <th>상품가격</th>
   <th>상품설명</th>
   <th>삭제하기</th>
 </tr>
  
  <c:choose>
  	<c:when test="${empty list}">
  		<tr>
  			<td colspan="6">검색된 레코드가 없습니다.</td>
  		</tr>
  	</c:when>
  	<c:otherwise>
  		<c:forEach items="${list}" var="p" varStatus="status">
  			<tr>
  				<td>${status.count}</td>
  				<td>${p.code}</td>
  				<td><a href="read.kosta?code=${p.code}">${p.name}</a></td>
  				<td>${p.price}</td>
  				<td>${p.detail}</td>
  				<td><input type="button" name="${p.code}" value="삭제하기"></td>
  			</tr>
  		</c:forEach>
  	</c:otherwise>
  </c:choose>
  
  <tr>
    <td colspan="6"><a href="insertForm.kosta">상품등록하기</a></td>
   </tr>
 
</table>


<form action="" method="post" >
</form>

</body>




</html>