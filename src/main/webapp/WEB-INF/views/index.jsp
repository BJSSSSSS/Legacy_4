<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="./template/header_css.jsp"></c:import>
	<style type="text/css">
		.hea{
			width : 80%;
			height: 200px;
			margin: 0 auto;
			overflow: hidden;
		}
	</style>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	
	<div>
		<img alt="" src="./resources/images/baby.jpg" class="hea">
	</div>
	
	
	
	<h1>Index Page</h1>
	
	<h3>${member.name}님 환영합니다
		<span class="material-icons-outlined">
			account_circle
		</span>
	</h3>
	
	<div>
		<c:if test="${not empty member}">
			<a href="./member/mypage">MyPage</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		
		<c:if test="${empty member}">
			<a href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
	</div> 
	
	<img alt="" src="./resources/upload/member/9353d992-83fd-4498-96c9-80276ea3aff1_톰캣 정리.png">
	
</body>
</html>	
	
	
	
	
	
	

