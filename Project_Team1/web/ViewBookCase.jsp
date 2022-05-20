<%@page import="entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/bookcase.css">
        <link href="css/bookcase.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div style="width:80%; margin-left:auto; margin-right:auto; background-color: white; height: 100vh; overflow: auto ;">
            <div class="container padding-bottom-3x mb-1">
                <div class="table-responsive shopping-cart">
                    <table class="table">
                        <thead>
                            <tr>
                                <th style="text-align: center;">The Name Of Book</th>
                                <th class="text-center">Detail</th>
                                <th class="text-center">Author</th>
                                <th class="text-center">CreateDate</th>
                                <th class="text-center">Category</th>
                                    <c:if test="${user != null}">
                                    <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="ClearBookCaseController?bookcaseid=${bcID}">Remove All</a></th>
                                    </c:if>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${listBookInBC}" var="o">
                                <tr>
                                    <td>
                                        <div class="product-item">
                                            <a class="product-thumb" href="detail?bid=${o.getBookID()}"><img src="${o.getImage()}" alt="Product"></a>
                                            <div class="product-info">
                                                <h4 class="product-title"><a href="#"><strong>${o.getBookTitle()}</strong></a>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-center" id="book-case-detail-the-book">
                                        <div style="text-align: left; max-height: 200px; overflow: auto;">
                                            ${o.getBrief()}
                                        </div>
                                    </td>
                                    <td class="text-center text-lg text-medium">${o.getAuthor()}</td>
                                    <td class="text-center text-lg text-medium">${o.getCreateDate()}</td>
                                    <td class="text-center text-lg text-medium">${o.getCategory()} </td>
                                    <td class="text-center text-lg text-medium">
                                        <a class="btn btn-sm btn-danger" href="DeleteBookInBookCaseController?bid=${o.getBookID()}">Delete</a>
                                    </td>
                                    <td class="text-center"><a class="remove-from-cart" href="" data-toggle="tooltip" title="" data-original-title="Remove item"><i class="fa fa-trash"></i></a></td>
                                </tr>  
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${emptyBookCase != null}">
                        <p style="color: red; font-size: 25px"> ${emptyBookCase}</p>
                    </c:if>
                </div>
                <div class="shopping-cart-footer">
                    <div class="column"><a class="btn btn-outline-secondary" href="HomeController"><i class="icon-arrow-left"></i>&nbsp;Back to home</a></div>
                </div>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <c:if test="${tag > 1}">
                        <li class="page-item">
                            <a class="page-link" href="ViewBookCaseController?index=${tag-1}" >Previous</a>
                        </li>
                    </c:if> 
                    <c:if test="${endP > 1 && endP >= tag}">
                        <c:forEach begin="1" end="${endP}" var="i">
                            <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="ViewBookCaseController?index=${i}">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag < endP}">
                            <li class="page-item">
                                <a class="page-link" href="ViewBookCaseController?index=${tag+1}">Next</a>
                            </li>
                        </c:if> 
                    </c:if>
                    <c:if test="${errorIndex != null}">
                        <p style="color:red; font-size: 20px">${errorIndex}</p>
                    </c:if>
                </ul>
            </nav>
        </div>
    </body>
</html>