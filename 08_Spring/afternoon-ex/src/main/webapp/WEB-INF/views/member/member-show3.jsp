<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
<%@ include file="../header.jsp"%>
    <h1>회원 목록 V3</h1>
    <ul>
        <li><b>ID - NAME</b></li>
        <c:forEach var="member" items="${memberList}">
            <li>${member.id} - ${member.name}</li>
        </c:forEach>
    </ul>
</body>
</html>
