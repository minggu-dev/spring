<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 .a{border:solid red 5px}
 span{width:150px; color:red}
 input{border:solid gray 1px}
 table{width:100%}
 th,td{border:1px gray solid; text-align:center;padding:3px}
 h2{text-align:center}
 
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery3.4.1min.js"></script>
<script type="text/javascript">

	$(function() {
		printMember();
		
		$('#customSel').click(function(){
			printMember();
		});
		
		/*아이디 중복체크*/
		$('#stNo').keyup(function(){
			if($(this).val()==''){
				$('#inForm span').text('학번중복결과여부');
				$('#btn').attr("disabled",false);
			}else{
				$.ajax({
					url:"check",
					type:"post",
					data:"stNo="+$(this).val(),
					dataType:"text",
					success:function(result){
						console.log(result)
						if(result=="사용중입니다."){
							$('#btn').attr("disabled",true);
						}else{
							$('#btn').attr("disabled",false);			
						}
						$('#inForm span').text(result);
					},error:function(err){
						alert("err : "+err);
					}
				})	
			}
		});
		
		
		/*가입하기*/
		$('#btn').click(function(){
			$.ajax({
				url:"insert",
				type:"post",
				data:$('#inForm').serialize(),//폼전송(name=value)
				dataType:"text",
				success:function(result){
					$('input[type=text]').val("");
					$('#inForm span').text('학번중복결과여부');
					printMember();
				},error:function(err){
					alert("err : "+err);
				}
			})
		})
		
		
		//삭제하기
		$('#listTable').on('click','input[value=삭제]',function(){
			$.ajax({
				url:"delete",
				type:"post",
				data:"stNo="+$(this).attr('id'),
				//data:{"stNo : $(this).attr('id')}
				dataType:"text",
				success:function(result){
					printMember();
				},error:function(err){
					alert("err : "+err);
				}
			})
		});
		
		
		//수정하기 폼
		$('#listTable').on('click','input[value=수정]',function(){
			var p = $(this).parents('tr');
			let str = "<td width='10%'>" + p.find('td:nth-child(1)').html() + "</td>";
			str += "<td width='20%'><input type='text' name='stName' value='" + p.find('td:nth-child(2)').html() + "'></td>";
			str += "<td width='10%'><input type='text' name='stAge' value='" + p.find('td:nth-child(3)').html() + "'></td>";
			str += "<td width='20%'><input type='text' name='stPhone' value='" + p.find('td:nth-child(4)').html() + "'></td>";
			str += "<td width='20%'><input type='text' name='stAddr' value='" + p.find('td:nth-child(5)').html() + "'></td>";
			str +='<td width="20%" colspan="2"><input type="button" value="수정하기" id="update"></td>';
			$(this).parents('tr').html(str);
		});
		
		
		//수정하기
		$('#listTable').on('click','input[value=수정하기]',function(){
			var p = $(this).parents('tr');
			$('#updateForm').find('input[name=stNo]').val(p.find('td:nth-child(1)').html());
			$('#updateForm').find('input[name=stName]').val(p.find('td:nth-child(2)>input').val());
			$('#updateForm').find('input[name=stAge]').val(p.find('td:nth-child(3)>input').val());
			$('#updateForm').find('input[name=stPhone]').val(p.find('td:nth-child(4)>input').val());
			$('#updateForm').find('input[name=stAddr]').val(p.find('td:nth-child(5)>input').val());
			$.ajax({
				url:"update",
				type:"post",
				data:$('#updateForm').serialize(),
				dataType:"text",
				success:function(result){
					printMember();
				},error:function(err){
					alert("err : "+err);
				}
			})
		});
		
	})

	//전체레코드 가져오기
	function printMember() {
		$.ajax({
			url:"select",
			type:"get",
			dataType:"json",
			success:function(result){
				$('#listTable tr:gt(0)').empty();
				
				var str = "";
				$.each(result,function(index,item){
					str+='<tr>';
					str+='<td width="10%">'+item.stNo+'</td>';
					str+='<td width="20%">'+item.stName+'</td>';
					str+='<td width="10%">'+item.stAge+'</td>';
					str+='<td width="20%">'+item.stPhone+'</td>';
					str+='<td width="20%">'+item.stAddr+'</td>';
					str+='<td width="10%"><input type="button" value="삭제" id='+item.stNo+'></td>';
					str+='<td width="10%"><input type="button" value="수정"></td>';
					str+='</tr>';
				});
				$('#listTable').append(str);
			},error:function(err){
				alert("err : "+err);
			}
		})
	}
	
	
</script>
</head>


<body>
	<h2>Student 입력</h2>

	<form name="insert" method="post" id="inForm">
		<table cellspacing="0">
			<tr bgcolor="pink">
				<th>학번</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<tr>
				<td style="text-align: left"><input type="text" size="8"
					name="stNo" id="stNo"> <span>학번중복결과여부</span></td>
				<td><input type="text" size="8" name="stName" id="stName"></td>
				<td><input type="text" size="4" name="stAge" id="stAge"></td>
				<td><input type="text" size="12" name="stPhone" id="stPhone"></td>
				<td><input type="text" size="30" name="stAddr" id="stAddr"></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="button"
					value="가입하기" id="btn"></td>
			</tr>
		</table>

		<br>

	</form>

	<hr color="red">

	<h2>Student 리스트 !</h2>
	<table cellspacing="0">
		<tr>
			<td style="text-align: right"><input type="button" value="가져오기"
				id="customSel"></td>
		</tr>
	</table>

	<table id="listTable" cellspacing="0">
		<tr bgcolor="pink">
			<th>학번</th>
			<th>이름</th>
			<th>나이</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>



	</table>

	<form id="updateForm">
		<input type="hidden" name="stNo" value="">
		<input type="hidden" name="stName" value="">
		<input type="hidden" name="stAge" value="">
		<input type="hidden" name="stPhone" value="">
		<input type="hidden" name="stAddr" value="">
	</form>

</body>
</html>