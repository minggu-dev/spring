<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width: 800px;
		border: 5px solid red;
	}
	th{
		border-collapse: collapse;
		border : 1px solid gray;
	}
	.a{
		width: 600px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th colspan="2">
				<tiles:insertAttribute name="top"/>
			</th>
		</tr>
		<tr>
			<th class="a">
				<tiles:insertAttribute name="content"/>
			</th>
			<th>
				<tiles:insertAttribute name="aside"/>
			</th>
		</tr>
		<tr>
			<th colspan="2">
				<tiles:insertAttribute name="footer"/>
			</th>
		</tr>
	</table>
</body>
</html>