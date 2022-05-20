<%-- 
    Document   : displayTest
    Created on : 18-Dec-2021, 22:48:58
    Author     : Dinh Tuan Minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="HomePage.css">
        <link href="HomePage.css" rel="stylesheet" type="text/css"/>
        <title>Document</title>
    </head>
    <body>
        <%@include file="headerHomepage.jsp" %>
        <div id="wrapper">
            <div class="title">
                <h1>Sách tìm kiếm <i class="fas fa-angle-right"></i></h1>
            </div>
            <div id="list-book-wrapper" class="container-fluid" style="padding-left: 90px;">
                <c:forEach items="${listBookSearch}" var="o">
                    <a href="detail?bid=${o.bookID}">
                        <div id="product-wrapper" class="d-inline-block">
                            <div class="produc-image">
                                <img src="${o.getImage()}" alt="" id="a-img-of-book-list">
                                <div class="product-name" id="a-link-name-of-book">${o.getBookTitle()}
                                </div>
                            </div>
                        </div>
                    </a>
                </c:forEach> 
            </div>

            <nav aria-label="Page navigation example" class="page-pagination">
                <ul class="pagination justify-content-center">
                    <c:if test="${tag > 1}">
                        <li class="page-item">
                            <a class="page-link " href="search?index=${tag-1}&titleBook=${bookTitleSearch}"><i class="fas fa-angle-double-left"></i>Previous</a>
                        </li>
                    </c:if> 
                    <c:if test="${endP > 1 && endP >= tag}">
                        <c:forEach begin="1" end="${endP}" var="i">
                            <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="search?index=${i}&titleBook=${bookTitleSearch}">${i}</a></li>
                            </c:forEach> 
                            <c:if test="${tag < endP}">
                            <li class="page-item">
                                <a class="page-link" href="search?index=${tag+1}&titleBook=${bookTitleSearch}"><i class="fas fa-angle-double-right"></i>Next</a>
                            </li>
                        </c:if> 
                    </c:if>
                    <c:if test="${errorIndex != null && errorMes == null}">
                        <p style="color:red; font-size: 20px">${errorIndex}</p>
                    </c:if>
                    <c:if test="${errorMes != null}">
                        <p style="color:red; font-size: 20px">${errorMes}</p>
                    </c:if>
                </ul>
            </nav>
        </div>


    </body>
</html>
