<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice Detail Page</h1>
	
	<h3>num : ${detail.num}</h3>
	<h3>title : ${detail.title}</h3>
	<h3>contents : ${detail.contents}</h3>
	<h3>writer : ${detail.writer}</h3>
	
	<!--regdit 어케 출력?  -->
	<!-- 1. java에서 Date를 원하는 포맷(String)으로 변경 (SimpleDateFormat)
	or
	2. jstl사용
	 -->
	
	<a href="./list">List</a>
	<a href="./delete">Delete</a>
	
</body>
</html>


