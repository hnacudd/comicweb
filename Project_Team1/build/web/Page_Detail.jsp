<%-- 
    Document   : Page_Detail
    Created on : Dec 17, 2021, 9:43:54 PM
    Author     : long
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="css/Page_Detail.css" rel="stylesheet" type="text/css"/>
        <title>Detail Page</title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <a href="HomeController" class="close">&times;</a>
                <div class="container-fliud">
                    <div class="wrapper row">
                        <div class="preview col-md-6">

                            <div class="preview-pic tab-content">
                                <div class="tab-pane active" style="text-align: center"><img src="${book.image}" /></div>
                            </div>

                        </div>
                        <div class="details col-md-6">
                            <h3 class="product-title">${book.bookTitle}</h3>
                            <div class="rating">
                                <div class="stars">
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                </div>
                                <span class="review-no">100.000.000 views </span>
                            </div>
                            <p class="product-description">${book.brief}</p>

                            <h5 class="sizes">Category:
                                <span style="color: #00BCD4">  ${book.category}</span>
                            </h5>
                            <h5 class="sizes">Author:
                                <span style="color: #00BCD4">  ${book.author}</span>
                            </h5>
                            <h5 class="sizes">Publisher:
                                <span style="color: #00BCD4">  ${book.publisher}</span>
                            </h5>
                            <div class="action">

                                <c:if test="${ownBook!=1 || user != null}">
                                    <a href="addBookUser?bid=${book.bookID}" class="add-to-cart btn btn-default">Add Book to bookcase</a>
                                </c:if>


                                <c:if test="${ownBook==1}">
                                    <a href="ViewBookCaseController" class="add-to-cart btn btn-default">View BookCase</a>
                                </c:if>


                                <a href="read?bid=${book.bookID}" class="add-to-cart btn btn-default">Read Book</a>
                            </div>
                            <c:if test="${addBooksuccess != null}">
                                <p style="color: green; font-size: 20px">${addBooksuccess}</p>
                            </c:if>
                            <c:if test="${bookexist != null}">
                                <p style="color: red; font-size: 20px">${bookexist}</p>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
