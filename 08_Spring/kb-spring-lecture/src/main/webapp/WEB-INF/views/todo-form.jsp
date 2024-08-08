<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member Register</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h1>할 일 추가 1</h1>
<form method="get" action="/todo/form/save">
    <label for="todo">할일 :</label>
    <input type="password" id="todo" name="todo" required>
    <br>
    <button type="submit">할일 추가</button>
</form>
</body>
</html>
