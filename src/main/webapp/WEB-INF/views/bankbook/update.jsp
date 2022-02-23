<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Update Page</h1>
	
	<form action="./update" method="POST">
		<input type="hidden" name="bookNumber" value="${dto.bookNumber}" readonly="readonly">
		BookName : <input type="text" name="bookName" value="${dto.bookName}">
		BookRate : <input type="text" name="bookRate" value="${dto.bookRate}">
		BookContents : <textarea rows="10" cols="" name="bookContents">${dto.bookContents}</textarea>
		<!-- textarea는 value값을 <>이 사이에 넣어야 적용 가능!</> -->
		BookSale :
		<div>
			판매<input type="radio" name="bookSale" value="1"> 
			판매중지<input type="radio" name="bookSale" value="0">
		</div>
		
		<div>
			CheckBox
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
		</div>
		
		<button type="submit">Update</button>
	</form>

</body>
</html>