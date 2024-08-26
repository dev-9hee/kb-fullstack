<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="../header2.jsp"%>
<h1>로그인 실패</h1>
<h2>${errMsg}</h2>
<a href="/user/login">로그인 페이지로 이동</a>
</body>
</html>
