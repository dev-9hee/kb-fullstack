<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<h1>로그인 입력 파라미터 출력</h1>
<%
    String userid = request.getParameter("userid");
    String Password = request.getParameter("Password");
    String strAge = request.getParameter("age");
    int age = strAge != null ? Integer.parseInt(strAge) : -1;
%>
아이디값 : <%= userid %> <br>
비밀번호 : <%= Password %> <br>
나이 : <%= age %>
</body>
