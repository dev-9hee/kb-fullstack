<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<h1>방문자수 조회하기 화면</h1>
<%
    int count = (Integer)application.getAttribute("countValue");
%>
현재까지 총 방문자수 : <%= count %>
</body>

