<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="../header2.jsp"%>
<h1>회원 가입 실패</h1>
<h2>${errMsg}</h2>
<a href="/user/register">회원가입 페이지로 이동</a>
</body>
</html>
