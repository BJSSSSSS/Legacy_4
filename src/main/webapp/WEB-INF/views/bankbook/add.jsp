<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Add Page</h1>
	
	<form action="./add" method="POST">
		BookName : <input type="text" name="bookName">
		BookRate : <input type="text" name="bookRate">
		BookContents : <textarea rows="10" cols="" name="bookContents"></textarea>
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
		
		<button type="submit">ADD</button>
	</form>

</body>
</html>