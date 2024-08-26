<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-md bg-primary navbar-dark sticky-top">
    <a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i> Backend</a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <!-- 좌측 메뉴 구성 -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">메뉴1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">메뉴2</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">메뉴3</a>
            </li>
        </ul>

        <!-- 우측 메뉴 -->
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <img src="https://randomuser.me/api/portraits/men/12.jpg"
                         class="avatar-sm"/>
                    admin
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fa-solid fa-right-from-bracket"></i> 로그아웃
                </a>
            </li>
        </ul>
    </div>
</nav>
