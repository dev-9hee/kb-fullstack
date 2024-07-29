<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <h1>게시판 페이지 입니다</h1>
    <form method="post" action="board">
        <label for="post">글 내용 : </label>
        <input type="text" id="post" name="post" required>
        <br>
        <button type="submit">글 전송</button>
    </form>
</body>
</html>
