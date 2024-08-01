<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Todo 보기</h1>

    <div>
        <a href="list">목록보기</a>
        <a href="update">수정하기</a>
    </div>

    <form action="delete" method="post">
        <input type="submit" value="삭제">
    </form>
</body>
</html>
