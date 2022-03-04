<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/s1/resources/css/form.css">
<style>
	.c1{
		color: red;
	}
	.c2{
		color: blue;
	}
</style>

</head>
<body>
	<h1>Member Join Page</h1>
	
	<div>
		<form class="frm" action="./join" method="post" id="frm">
			<fieldset>
				<legend>ID : </legend>
				<input type="text" name="id" id="id">
				<div id="idResult" class=""></div>
			</fieldset>
		
			<fieldset>
				<legend>PW : </legend>
				<input type="password" id="pw" name="pw" placeholder="8글자 이상 12글자 이하로 작성하세요">
				<div id="pwResult" class=""></div>
			</fieldset>

			<fieldset>
				<legend>PW 확인 : </legend>
				<input type="password" id="pw2" name="pw2" placeholder="8글자 이상 12글자 이하로 작성하세요">
				<div id="pwResult2" class=""></div>
			</fieldset>

			<fieldset>
				<legend>NAME : </legend>
				<input type="text" name="name" id="name">
			</fieldset>
			
			<fieldset>
				<legend>PHONE : </legend>
				<input type="text" name="phone" id="phone">
			</fieldset>
			
			<fieldset>
				<legend>EMAIL : </legend>
				<input type="text" name="email" id="email">
			</fieldset>
			
			<fieldset>
				<button type="button" id="btn">JOIN</button>
			</fieldset>
		</form>
	</div>
	
	<script src="../resources/js/join2.js"></script>
	
</body>
</html>