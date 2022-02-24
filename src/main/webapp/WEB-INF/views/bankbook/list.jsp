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
	<h1> BankBook List Page </h1>
	
	<!-- bookName, bookRate, bookSale -->
	<table>
	
		<thead>
			<tr>
				<th>상품번호</th><th>상품명</th><th>이자율</th><th>판매여부</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="bankbook">
				<tr>
					<td>${bankbook.bookNumber}</td>
					<td><a href="./detail?bookNumber=${bankbook.bookNumber}">${bankbook.bookName}</a></td>
					<td>${bankbook.bookRate}</td>
					<td>${bankbook.bookSale}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
	<div>
		<c:if test="${pager.pre}">
			<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
		</c:if>
	
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i"><!-- step은 기본값이 1 -->
			<a href="./list?page=${i}">${i}</a>
		</c:forEach>
		
		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastNum+1}">NEXT</a>
		</c:if>
	</div>
	
	<a href="./add">ADD</a>
	
	
</body>
</html>






