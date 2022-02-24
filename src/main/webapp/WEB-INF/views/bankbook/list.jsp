<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="stylesheet">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1> BankBook List Page </h1>
	
	<!-- bookName, bookRate, bookSale -->
	<table>
	
		<thead>
			<tr>
				<th>상품명</th><th>이자율</th><th>판매여부</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="bankbook">
				<tr>
					<td><a href="./detail?bookNumber=${bankbook.bookNumber}">${bankbook.bookName}</a></td>
					<td>${bankbook.bookRate}</td>
					<td>${bankbook.bookSale}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
	<a href="./add">ADD</a>
	<a href="../">HOME</a>	
	
</body>
</html>






