<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>로그인</h1>
<form method="post" action="login">
    <label for="username">아이디 : </label>
    <input id="username" type="text" name="username" required>
    <br>
    <label for="password">비밀번호 : </label>
    <input id="password" type="password" name="password" required>
    <br>
    <button type="submit">로그인</button>
</form>
</body>
</html>
