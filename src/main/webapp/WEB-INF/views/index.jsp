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
<!-- 	왜안되지
	<div id="map" style="width:500px;height:400px;"></div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 key"></script>
	<script type="text/javascript">
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
		};
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	</script> -->
</body>
</html>	
	
	
	
	
	
	

