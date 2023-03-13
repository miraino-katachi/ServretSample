<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Memo"%>
<%
// リクエストスコープから注文内容を取得
Memo memo = (Memo) request.getAttribute("memo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
	<h1>注文の確認</h1>
	<p>ただいまの注文：<%=memo.getMemo()%></p>
	<a href="inputOrder.jsp">注文入力画面へ</a>
</body>
</html>