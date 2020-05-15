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
	<h1>업로드 성공</h1>
	이름 : ${name}<br>
	파일명 : ${fileName}<br>
	파일크기 : ${fileSize}<br>
	경로 : ${path}<br>
	<br>
	<hr>
	
	<h1>업로드 성공 - UploadDTO객체</h1>
	이름 : ${dto.name}<br>
	파일명 : ${dto.fileName}<br>
	파일크기 : ${dto.fileSize}<br>
	경로 : ${dto.path}<br>
</body>
</html>