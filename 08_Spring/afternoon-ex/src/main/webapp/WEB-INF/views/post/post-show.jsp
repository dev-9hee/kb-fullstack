<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .new-button {
            display: inline-block;
            padding: 10px 15px;
            margin-top: 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }

        .new-button:hover .btn {
            background-color: #45a049;
        }

        .update-button  {
            background-color: #3093f5;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }

        .update-button:hover {
            background-color: #3561e5;
        }

        .delete-button {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete-button:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
<%@include file="../header2.jsp"%>
<h1>글 목록</h1>

<form action="/post/v1/search" method="get">
    <label for="title">제목 검색</label>
    <input type="text" name="title" id="title" placeholder="제목에서 찾을 단어 입력">
    <label for="content">/ 내용 검색</label>
    <input type="text" name="content" id="content" placeholder="내용에서 찾을 단어 입력">
    <input type="submit" value="검색">
</form>
<br />

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Content</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${postList}">
        <tr>
            <td>${post.id}</td>
            <td>${post.title}</td>
            <td>${post.content}</td>
            <td>
                <form action="/post/v1/update" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="${post.id}">
                    <input type="submit" value="수정" class="update-button">
                </form>
                <form action="/post/v1/delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${post.id}">
                    <input type="submit" value="삭제" class="delete-button">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a class="new-button" href="/post/v1/new">새글 작성하기</a>
</body>
</html>
