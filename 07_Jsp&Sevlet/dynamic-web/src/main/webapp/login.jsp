<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<h1>로그인 정보 세션 저장</h1>
<%
    String id = request.getParameter("userid");
    if (id == null || id.equals("")) {
        response.sendRedirect("loginForm.html.jsp");
    } else {
        String pw = request.getParameter("Password");
        session.setAttribute("userid", id);
        session.setAttribute("Password", pw);
        out.print("안녕하세요" + id);
        out.print("<a href='loginInfo2.jsp'>정보보기</a>");
    }
%>
</body>

