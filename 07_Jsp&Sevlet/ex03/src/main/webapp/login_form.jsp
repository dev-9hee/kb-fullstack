<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<h1>getParameter 실습</h1>
<form action="login" method="post">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul>
            <li><label for="userid">아이디</label>
                <input id="userid" type="text" name="userid"></li>
            <li><label for="passwd">비밀번호</label>
                <input id="passwd" type="password" name="passwd"></li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>

