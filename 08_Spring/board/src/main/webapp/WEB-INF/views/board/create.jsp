<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>

<h1 class="page-header my-4"><i class="far fa-edit"></i> 새 글쓰기</h1>

<div >
    <form method="post" enctype="multipart/form-data">
        <div>
            <label>제목</label>
            <input name="title" class="form-control">
        </div>

        <div>
            <label>작성자</label>
            <input name="writer" class="form-control">
        </div>

        <div>
            <label>첨부파일</label>
            <input type="file" class="form-control-file border" multiple name="files"/>
        </div>

        <div>
            <label>내용</label>
            <textarea class="form-control" name="content" rows="10"></textarea>
        </div>

        <button type="submit" class="btn btn-primary"><i class="fas fa-check"></i> 확인</button>
        <button type="reset" class="btn btn-primary"><i class="fas fa-undo"></i> 취소</button>
        <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
    </form>

</div>

<%@include file="../layouts/footer.jsp"%>

