<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<h1>로그인 입력 화면</h1>
<form action="loginInfo.jsp" method="get">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul>
            <li>
                <label for="userid">아이디</label>
                <input id="userid" type="text" name="userid">
            </li>
            <li>
                <label for="Password">비밀번호</label>
                <input id="Password" type="password" name="Password">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>

