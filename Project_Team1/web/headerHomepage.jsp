<%-- 
    Document   : headerHomepage
    Created on : Dec 19, 2021, 10:19:48 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <header>
            <div class="header-menu">
                <ul>
                    <li>
                        <a href="HomeController">Trang chủ</a>
                    </li>
                    <li><a href="ViewBookCaseController">View Book Case</a></li>
                    
                </ul>
            </div>
        </header>
        <div id="header-search">
            <div id="inside-header-search">
                <div id="search-login-home">
                    <div class="container" id="logo">
                        <a href="">Thần tài nổ hũ 8 team
                            <img src="" alt="" srcset="">
                        </a>
                    </div>
                    <div class="container" id="searchForm">
                        <form class="example" method="get" action="search">
                            <input type="text" placeholder="Search.." name="titleBook" class="input-search" value="${bookTitleSearch}">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="container" id="contain-login-header">
                        <c:if test="${user == null}">
                        <div style="width: 50%;">
                            <a href="LoginController" id="btn-login-head">Đăng nhập</a>
                        </div>
                        <div style="width: 50%;">
                            <a href="register" id="btn-create-account">Đăng kí</a>
                        </div>
                        </c:if>
                        <c:if test="${user != null}">
                            <p style="color: #fff">Welcome ${user}</p>
                            <div style="width: 50%;">
                            <a href="LogoutController" id="btn-create-account">Logout</a>
                        </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
