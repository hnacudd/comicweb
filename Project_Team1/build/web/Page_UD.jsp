<%-- 
    Document   : test
    Created on : 12-Dec-2021, 21:56:43
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
        <title>Document</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" href="css/bookcase.css">
        <script src="js/deletejs.js" type="text/javascript"></script>
        <link href="css/Page_Admin.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="Page_Navigation.jsp" %>
        <div style="width:80%; margin-left:15%; margin-right:auto; background-color: white; height: 100vh; overflow: auto ;">
            <div class="container padding-bottom-3x mb-1">
                <div class="table-responsive shopping-cart">

                    <table class="table">
                        <thead>
                            <tr>
                                <th style="text-align: center;">The name of Book</th>

                                <th class="text-center">Update</th>
                                <th class="text-center">Delete</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items= "${listB}"  var = "list">
                                <tr>
                                    <td>
                                        <div class="product-item">
                                            <a class="product-thumb" href="#">
                                                <img src="${list.image}" alt="Product">
                                            </a>
                                            <div class="product-info">
                                                <h4 class="product-title"><a href="#"><strong>${list.bookTitle}</strong></a>
                                            </div>
                                        </div>
                                    </td>

                                    <td class="text-center text-lg text-medium"> 
                                        <button class="btn btn-sm btn-success">
                                            <a class="link-ud" style="padding: 5px; font-size: 25px;" href="update?bookID=${list.getBookID()}">Update</a>    
                                        </button>
                                    </td>

                                    <td class="text-center text-lg text-medium">
                                        <form id="formDelete" method="POST" action="delete">
                                            <input type="text" style="display: none" name="bookID" value="${list.getBookID()}">
                                            <input type="submit" class="btn btn-sm btn-danger" onclick="isDelete()" name="delete" value="Delete" style="padding: 5px; font-size: 25px;">
                                            <!--                                            <button class="btn btn-sm btn-danger">
                                                                                            <a  class="link-ud" href="delete?bookID=${list.getBookID()}">Delete</a>  
                                                                                        </button>-->
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
            <nav aria-label="Page navigation example" class="page-pagination">
                <ul class="pagination justify-content-center">
                    <c:if test="${tag > 1}">
                        <li class="page-item">
                            <a class="page-link " href="u1?index=${tag-1}"><i class="fas fa-angle-double-left"></i>Previous</a>
                        </li>
                    </c:if> 
                    <c:if test="${endP > 1 && endP >= tag}">
                        <c:forEach begin="1" end="${endP}" var="i">
                            <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="u1?index=${i}">${i}</a></li>
                            </c:forEach> 
                            <c:if test="${tag < endP}">
                            <li class="page-item">
                                <a class="page-link" href="u1?index=${tag+1}"><i class="fas fa-angle-double-right"></i>Next</a>
                            </li>
                        </c:if> 
                    </c:if>
                    <c:if test="${errorIndex != null}">
                        <p style="color:red; font-size: 20px">${errorIndex}</p>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>

</body>
</html>
