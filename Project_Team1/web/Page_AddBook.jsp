<%-- 
Document   : Page_AddBook
Created on : Dec 10, 2021, 9:00:16 PM
Author     : long
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" href="css/Page_Add.css">
        <script type="text/javascript" src="js/addjs.js"></script>
        <title>Add Book Page</title>
        <script src="js/admin.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="css/Page_Admin.css" rel="stylesheet" type="text/css"/>
        <script src="js/validateAddUpdateForm.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/Page_Add.css">
        <script type="text/javascript" src="js/addjs.js"></script>
        <script src="js/admin.js"></script>
        <link href="css/Page_Admin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="Page_Navigation.jsp" %>

        <div id="wrapper">
            <div class="row d-flex justify-content-center">
                <div class="wraaper">
                    <div class="card">
                        <h5 class="text-center mb-4">Add</h5>
                        <form  class="form-card contact-forms" name="add-form" id="formAU" method="POST" action="addBook">
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-sm-6 flex-column d-flex vali"> <label class="form-control-label px-3">Book Title<span class="text-danger"> *</span></label> 
                                    <input type="text" id="title" name="title" value="${bookTitle}" placeholder="Enter book title" onblur="validate(1)"> 
                                    <div class="form-mess"></div>
                                    <span class="text-danger"> ${exitBook}</span>
                                </div>
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Author<span class="text-danger"> *</span></label> 
                                    <input type="text" id="author" name="author" placeholder="Enter book author" onblur="validate(2)"> 
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Publisher<span class="text-danger"> *</span></label> 
                                    <input type="text" id="publisher" name="publisher" placeholder="Enter book publisher" onblur="validate(3)"> 
                                    <div class="form-mess"></div>
                                </div>
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Category<span class="text-danger"> *</span></label>
                                    <input type="text" id="category" name="category" placeholder="Enter book category" onblur="validate(10)">
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-12 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Content<span class="text-danger"> *</span></label> 
                                    <textarea id="content" name="content" placeholder="" onblur="validate(5)"></textarea>
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-12 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Brief<span class="text-danger"> *</span></label> 
                                    <textarea id="brief" name="brief" placeholder="" onblur="validate(6)"></textarea>
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-12 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Image<span class="text-danger"> *</span></label> 
                                    <input type="file" id="image" name="image" placeholder="Enter image URL"> 
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-end">
                                <div class="form-group col-sm-6"> <button type="submit" class="btn-block btn-primary">Add</button> </div>
                            </div>
                        </form>
                        <c:if test="${successAd != null}">
                            <p style="color: green; font-size: 25px">${successAd}</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
    </body>
</html>
