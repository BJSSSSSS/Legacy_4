<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My Page Update</h1>
	
	<form action="./update" method="post">
		<input type="hidden" name="id" value="${dto.id}">
		name : <input type="text" name="name" value="${dto.name}">
		phone : <input type="text" name="phone" value="${dto.phone}">
		email : <input type="text" name="email" value="${dto.email}">
		
		<button type="submit">UPDATE</button>		
	</form>
	
	<a href="../">HOME</a>

</body>
</html>