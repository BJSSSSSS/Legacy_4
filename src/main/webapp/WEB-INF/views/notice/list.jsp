<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="table-cotainer">

		<h1 class="title">Notice List Page</h1>


		<form action="./list" class="search" method="get">
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">내용</option>
					<option value="col3">작성자</option>
					
<%-- 					<c:if test="${pager.kind}==col1">
						<option value="col1" selected>제목</option>
						<option value="col2">내용</option>
						<option value="col3">작성자</option>
					</c:if>
					<c:if test="${pager.kind}==col2">
						<option value="col1">제목</option>
						<option value="col2" selected>내용</option>
						<option value="col3">작성자</option>
					</c:if>
					<c:if test="${pager.kind}==col3">
						<option value="col1">제목</option>
						<option value="col2">내용</option>
						<option value="col3" selected>작성자</option>
					</c:if>
					 --%>
				</select>
				<input type="text" name="search" value="${pager.search}">
				<button type="submit">검색</button>
			</fieldset>
		</form>


		<table class="table-total">
			<thead>
				<tr>
					<th>번호</th><th>제목</th><th>내용</th><th>글쓴이</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.num}</td>
						<td><a href="./detail?num=${list.num}">${list.title}</a></td>
						<td>${list.contents}</td>
						<td>${list.writer}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
		
		
			<c:if test="${pager.pre}">
				<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<a href="./list?page=${i}&kind=${pager.kind} &search=${pager.search}">${i}</a>
			</c:forEach>
			<c:if test="${pager.next}">
				<a href="./list?page=${pager.lastNum+1}">NEXT</a>
			</c:if>
			
			
		</div>
		
		<a href="./add">ADD</a>
	</div>
</body>
</html>