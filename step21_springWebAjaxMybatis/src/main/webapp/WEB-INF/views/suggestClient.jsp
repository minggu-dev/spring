<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery3.4.1min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script>
	$(function(){
		$.ajax({
			url : "suggest",
			data : "word=" +$( "#keyWord" ).val(),
			dataType : "json",
			method : "post",
			success : function(result){
				$( "#keyWord" ).autocomplete({
					source: result
				});
			},
			error : function(err){
				alert("오류 발생 = " + err);
			}
		});
	});
</script>


</head>
<body>
<h3> [ Suggest 기능 구현 ]</h3>	
<form name="search" id="search">
	<input type="text" name="word" id="keyWord"/>
</form>

<!--제시어 단어 출력부분 -->

</body>
</html>








