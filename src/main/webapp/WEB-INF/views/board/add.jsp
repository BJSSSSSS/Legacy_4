<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="styleSheet"/>
<link href="../resources/css/list.css" rel="styleSheet"/>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<h1>${board} Add Page</h1>
	

	<form action="./add" method="POST" id="frm" enctype="multipart/form-data">
		TITLE :<input type="text" name="title" id="title">
		CONTENTS : <textarea rows="" cols="" name="contents"></textarea>
		WRITER :<input type="text" name="writer" id="writer">
	
		<div>
		<!-- controller에 넘길때 파라미터 이름과 동일하게 넘길것! -->
			<input type="file" name="files">
			<input type="file" name="files">
			<input type="file" name="files">
		</div>
	
		<button type="button" id="btn">ADD</button>

	</form>

	<a href="./list">List</a>
	<script src="../resources/js/noticeAdd.js"></script>
</body>
</html>