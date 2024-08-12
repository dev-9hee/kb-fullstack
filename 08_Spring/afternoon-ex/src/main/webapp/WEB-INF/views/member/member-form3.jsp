<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member Register</title>
</head>
<body>
<%@ include file="../header.jsp"%>
<h1>회원 추가 V3</h1>
<form method="post" action="/member/v3/form/save">
    <label for="id">아이디 :</label>
    <input type="text" id="id" name="id" required>
    <br>
    <label for="name">이름 :</label>
    <input type="text" id="name" name="name" required>
    <br>
    <button type="submit">회원 추가</button>
</form>
</body>
</html>