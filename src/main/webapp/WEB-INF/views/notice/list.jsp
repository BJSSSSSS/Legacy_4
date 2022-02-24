<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>Notice List Page</h1>
	
	<table>
		<thead>
			<tr>
				<th>제목</th><th>내용</th><th>글쓴이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td><a href="./detail?num=${list.num}">${list.title}</a></td>
					<td>${list.contents}</td>
					<td>${list.writer}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="./add">ADD</a>
	<a href="../">HOME</a>

</body>
</html>