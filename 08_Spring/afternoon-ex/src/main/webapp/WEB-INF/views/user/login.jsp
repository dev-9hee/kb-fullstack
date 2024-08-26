<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="../header2.jsp"%>
<h1>로그인</h1>
<form action="/user/login" method="post">
    아이디: <input type="text" name="username"><br>
    비밀번호: <input type="password" name="password"><br>
    <input type="submit" value="로그인"/>
</form>
</body>
</html>






<%--<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@include file="../header2.jsp"%>--%>
<%--<h1>로그인</h1>--%>
<%--<form action="/user/login" method="post">--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--    아이디: <input type="text" name="username"><br>--%>
<%--    비밀번호: <input type="password" name="password"><br>--%>
<%--    <input type="submit" value="로그인"/>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>