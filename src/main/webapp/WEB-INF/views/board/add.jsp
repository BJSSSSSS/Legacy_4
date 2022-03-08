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
	
	<form action="./add" method="POST">
		TITLE :<input type="text" name="title">
		WRITER :<input type="text" name="writer">
		CONTENTS : <textarea rows="" cols="" name="contents"></textarea>
		
		<button type="submit">ADD</button>
	</form>

	<a href="./list">List</a>
</body>
</html>