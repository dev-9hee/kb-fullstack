<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>500</title>
</head>
<body>
<%@ include file="../header2.jsp"%>
<h1>죄송합니다. 예상치 못한 에러가 발생했습니다.</h1>
<a href="/">홈 페이지로 돌아가기</a>
<h4><c:out value="${errorMessage}"></c:out></h4>
<ul>
    <c:forEach items="${stackTrace}" var="stack">
        <li><c:out value="${stack}"></c:out></li>
    </c:forEach>
</ul>
</body>
</html>
