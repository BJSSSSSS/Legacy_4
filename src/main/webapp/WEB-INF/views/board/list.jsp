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


	<div class="table-container">

		<h1 class="title">${board} List Page</h1>


		<form action="./list" class="search" method="get">
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">내용</option>
					<option value="col3">작성자</option>
				</select>
				<input type="text" name="search" value="${pager.search}">
				<button type="submit">검색</button>
			</fieldset>
		</form>


		<table class="table-basic">
			<tr>
				<th>글번호</th><th>글제목</th><th>작성자</th><th>생성일</th><th>조회수</th>
			</tr>

			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td>
						<a href="./detail?num=${dto.num}">
							<!--  공백으로 밀고싶을땐 > < 안에 &nbsp; -->
							<c:catch>
								<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
							</c:catch>
							${dto.title}
						</a>
					</td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>
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
		<c:if test="${not empty member}">
			<a href="./add">ADD</a>
		</c:if>
	</div>
</body>
</html>