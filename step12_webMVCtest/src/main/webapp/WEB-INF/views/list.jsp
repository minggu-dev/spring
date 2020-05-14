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
		text-align: right;
		width : 80%;
	}
	
	table{
		text-align: center;
		width : 100%;
	}
	a{
		text-decoration: none;
	}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$('.delete').click(function(){
			$('form[name=deleteForm]').find('input').val($(this).attr('name'));
			$('form[name=deleteForm]').submit();
		})
		
		$('a.read').click(function(){
			$('form[name=readForm]').find('input').val($(this).attr("href"));
			$('form[name=readForm]').submit();
			return false;
		})
	})
	
</script>
</head>
<body>
<h1>게시판</h1>
<div>
	<a href="insertForm.kosta">등록하기</a>
	<table>
		<tr>
			<th width="10%">번호</th>
			<th width="30%">제목</th>
			<th width="20%">작성자</th>
			<th width="20%">날짜</th>
			<th width="20%">삭제</th>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.no}</td>
				<td><a href="${board}" class="read">${board.subject}</a></td>
				<td>${board.writer}</td>
				<td>${board.date}</td>
				<td><input type="button" name="${board}" class="delete" value="삭제하기"></td>
			</tr>
		</c:forEach>
	</table>
	
	<form action="delete.kosta" name="deleteForm">
		<input type="hidden" name="board" value="">
	</form>
	
	<form action="read.kosta" name="readForm">
		<input type="hidden" name="board" value="">
	</form>
</div>
</body>
</html>