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
	<h1>Notice Add Page</h1>
	
	<form action="./add" method="POST">
		TITLE :<input type="text" name="title">
		CONTENTS : <textarea rows="" cols="" name="contents"></textarea>
		WRITER :<input type="text" name="writer">
	
		<button type="submit">ADD</button>
	</form>

	<a href="./list">List</a>
</body>
</html>