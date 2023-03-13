<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
<h1>注文してください。</h1>
<form action="/ServletSample/OrderServlet" method="post">
	<input type="text" name="order">
	<input type="submit" value="これで注文する！">
</form>
</body>
</html>