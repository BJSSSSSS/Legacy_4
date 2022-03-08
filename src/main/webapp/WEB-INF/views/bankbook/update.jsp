<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${board} Update Page</h1>
	
	<form action="./update" method="POST">
	
		<input type="hidden" name="num" value="${dto.num}">
		TITLE : <input type="text" name="title" value="${dto.title}">
		CONTENTS : <textarea rows="" cols="" name="contents">${dto.contents}</textarea>
		WRITER : <input type="text" name="writer" value="${dto.writer}" readonly="readonly">
	
		<button type="submit">UPDATE</button>
		
	</form>

	<a href="./list">List</a>

</body>
</html>