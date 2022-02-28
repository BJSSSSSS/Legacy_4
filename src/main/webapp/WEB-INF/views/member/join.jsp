<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/s1/resources/css/form.css">
</head>
<body>
	<h1>Member Join Page</h1>
	
	<div>
		<form class="frm" action="./join" method="post">
			<fieldset>
				<legend>ID : </legend>
				<input type="text" name="id">
			</fieldset>
		
			<fieldset>
				<legend>PW : </legend>
				<input type="password" name="pw">
			</fieldset>
			
			<fieldset>
				<legend>NAME : </legend>
				<input type="text" name="name">
			</fieldset>
			
			<fieldset>
				<legend>PHONE : </legend>
				<input type="text" name="phone">
			</fieldset>
			
			<fieldset>
				<legend>EMAIL : </legend>
				<input type="text" name="email">
			</fieldset>
			
			<fieldset>
				<button type="submit">JOIN</button>
			</fieldset>
		</form>
	</div>
	
	
</body>
</html>