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
	<h1>${board} Update Page</h1>
	
	<form action="./update" method="POST">
		<input type="hidden" name="num" value="${dto.num}">
		Writer : <input type="text" name="writer" value="${dto.writer}" disabled>
		Title : <input type="text" name="title" value="${dto.title}">
		Contents : <textarea rows="" cols="" name="contents">${dto.contents}</textarea>
		<button type="submit">Update</button>
	</form>

</body>
</html>

