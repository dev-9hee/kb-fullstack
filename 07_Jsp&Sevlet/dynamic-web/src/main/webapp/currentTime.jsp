<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<body>
    <h1>현재 날짜 출력 실습</h1>
    <%
        Date d = new Date();
    %>
    현재 날짜 : <%= d %>
</body>

