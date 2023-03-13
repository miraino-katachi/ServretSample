<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Memo"%>
<%
// セッションスコープから注文内容を取得
Memo memo = (Memo) session.getAttribute("memo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更画面</title>
</head>
<body>
	<h1>ご注文内容の変更をどうぞ</h1>
	<p>変更対象の注文：<%=memo.getMemo()%></p>
	<form action="/ServletSample/OrderServletForSession" method="post">
		変更後の注文：<input type="text" name="order"> 
		<input type="submit" value="変更する！">
	</form>
</body>
</html>