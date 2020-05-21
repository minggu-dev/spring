<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery3.4.1min.js"></script>
<script type="text/javascript">
  	$(function(){
		$('#loadBtn').click(function(){
			$('#display').load('load');//서버 주소를 넣어준다.
		});
		
		//ajaxBtn
		$('#ajaxBtn').click(function(){
			$.ajax({
				url : 'ajax',
				type : 'post',
				dataType : 'text',
				data : 'name=민호',
				success : function(result){
					//alert(result);
					$('#display').text(result);
				},
				error : function(err){
					alert("오류발생 : " + err);
				}
			});
		});
		
		//arrayBtn
		$('#arrayBtn').click(function(){
			$.ajax({
				url : 'array',
				type : 'post',
				dataType : 'json',
				//data : 'name=민호',
				success : function(result){
					//alert(result);
					let str="";
					$.each(result, function(index, item){
						str +="<input type='checkbox' value='" + index + "'>" + item;
					})
					$('#display').html(str);
				},
				error : function(err){
					alert("오류발생 : " + err);
				}
			});
		});
		
		//dtoBtn
		$('#dtoBtn').click(function(){
			$.ajax({
				url : 'jsonDTO',
				type : 'post',
				dataType : 'json',
				//data : 'name=민호',
				success : function(result){
					$('#display').text(result.id + " | " + result.age + " | " + result.addr + " | " + result.phone);
				},
				error : function(err){
					alert("오류발생 : " + err);
				}
			});
		});
		
		//listBtn
		$('#listBtn').click(function(){
			$.ajax({
				url : 'jsonList',
				type : 'post',
				dataType : 'json',
				//data : 'name=민호',
				success : function(result){
					let str = "<table><tr><th>id</th><th>주소</th><th>나이</th><th>번호</th></tr>";
					$.each(result, function(index, item){
						str += "<tr><td>" + item.id + "</td>";
						str += "<td>" + item.addr + "</td>";
						str += "<td>" + item.age + "</td>";
						str += "<td>" + item.phone + "</td></tr>";
					})
					str += "</table>";
					$('#display').html(str);
				},
				error : function(err){
					alert("오류발생 : " + err);
				}
			});
		});
		
		
		//mapBtn
		$('#mapBtn').click(function(){
			$.ajax({
				url : 'jsonMap',
				type : 'post',
				dataType : 'json',
				//data : 'name=민호',
				success : function(result){
					alert(result.message + " | " + result.pageNum);
					alert(result.dto + " | " + result.dto.id);
					$.each(result.memberList, function(index, item){
						alert(item.id);
					})
				},
				error : function(err){
					alert("오류발생 : " + err);
				}
			});
		});
		
		
  	});//ready 끝
</script>
</head>
<body>

<input type="button" value="load함수" id="loadBtn">
<input type="button" value="ajax함수" id="ajaxBtn">

<input type="button" value="json결과(array)" id="arrayBtn">
<input type="button" value="json결과(DTO)" id="dtoBtn">
<input type="button" value="json결과(List)" id="listBtn">
<input type="button" value="json결과(Map)" id="mapBtn">

<hr>
<div id="display"></div>



</body>
</html>



