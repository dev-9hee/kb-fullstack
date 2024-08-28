<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String REST_API_KEY = "df54dc30e8f798244f495a54d2f3c0e2";
    String REDIRECT_URI = "http://localhost:8080/kakao/login";
    String KAKAO_URI = "https://kauth.kakao.com/oauth/authorize?client_id=" + REST_API_KEY + "&redirect_uri=" + REDIRECT_URI + "&response_type=code";
%>
<header>
    <h3>V1</h3>
    <a href="/">HOME</a>
    <a href="/post/v1/show">게시글 목록</a>
    <a href="/post/v1/404">404</a>
    <a href="/post/v1/error">error</a>
    <h3>회원 기능</h3>
    <a href="/user/register">회원가입</a>
    <a href="/user/login">로그인</a>
    <a href="/user/logout">로그아웃</a>
    <a href="/user/admin">admin</a>
    <h3>시큐리티 회원 기능</h3>
    <a href="/security/admin">admin</a>
    <a href="/security/member">member</a>
    <a href="/security/login">로그인</a>
    <a href="#" onclick="document.getElementById('logout-form').submit();">로그아웃</a>
    <form id="logout-form" action="/security/logout" method="post" style="display: none;">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <a href="<%= KAKAO_URI %>">카카오 로그인</a>
</header>