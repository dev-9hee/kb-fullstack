<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<%
    // 에러를 강제로 발생시키기 위해 사용
    int a = 4;
    int b = 0;
    int result = a / b;
%>
