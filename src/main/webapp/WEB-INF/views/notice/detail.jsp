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
	
	<h3>num : ${dto.num}</h3>
	<h3>title : ${dto.title}</h3>
	<h3>contents : ${dto.contents}</h3>
	<h3>writer : ${dto.writer}</h3>
	
	<!--regdit 어케 출력?  -->
	<!-- 1. java에서 Date를 원하는 포맷(String)으로 변경 (SimpleDateFormat)
	or
	2. jstl사용
	 -->
	
	<a href="./list">List</a>
	<a href="./update?num=${dto.num}">Update</a>
	<a href="./delete?num=${dto.num}">Delete</a>
	
</body>
</html>


