<%-- 
    Document   : Page_UpdateBook
    Created on : Dec 14, 2021, 3:35:54 PM
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
        <link rel="stylesheet" href="css/Page_Update.css">
        <link href="css/Page_Admin.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/updatejs.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/validateAddUpdateForm.js" type="text/javascript"></script>
        <title>Update Page</title>
    </head>
    <body>
        <%@include file="Page_Navigation.jsp" %>
        <div id="wrapper">
            <div class="row d-flex justify-content-center">
                <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">


                    <div class="card">
                        <div class="row justify-content-between text-left">
                            <a href="">BACK</a>
                        </div>
                        <h4 class="text-center mb-4">Update Book</h4>
                        <form class="form-card contact-forms" name="add-form" id="formAU" method="POST" action="update">
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">BookID<span class="text-danger"> *</span></label> 
                                    <input type="text" id="title" value="${bookID}" readonly="" name="bookID"> 
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Book Title<span class="text-danger"> *</span></label> 
                                    <input type="text" id="title" value="${title}" readonly="" name="title"  onblur="validate(1)"> 
                                    <div class="form-mess"></div>
                                </div>
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Author<span class="text-danger"> *</span></label> 
                                    <input type="text" id="author" value="${author}" name="author"  onblur="validate(2)"> 
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Publisher<span class="text-danger"> *</span></label> 
                                    <input type="text" value="${publisher}"  id="publisher" name="publisher" onblur="validate(3)"> 
                                    <div class="form-mess"></div>
                                </div>
                                <div class="form-group col-sm-6 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Category<span class="text-danger"> *</span></label> 
                                    <input type="text" value="${category}" id="category" name="category"  onblur="validate(10)"> 
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-12 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Content<span class="text-danger"> *</span></label> 
                                    <textarea id="content" name="content"  placeholder="" onblur="validate(5)">${content}</textarea>
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-12 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Brief<span class="text-danger"> *</span></label> 
                                    <textarea id="brief"  name="brief" placeholder="" onblur="validate(6)">${brief}</textarea>
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-12 flex-column d-flex vali"> 
                                    <label class="form-control-label px-3">Image<span class="text-danger"> *</span></label> 
                                    <input type="file" id="image" value="123" name="image"> 
                                    <div class="form-mess"></div>
                                </div>
                            </div>
                            <div class="row justify-content-end">
                                <div class="form-group col-sm-6"> <button type="submit" class="btn-block btn-primary">Update</button> </div>
                            </div>
                        </form>
                        <c:if test="${success!= null}">
                            <p class="successU" style="color: green;font-size: 25px;">${success}</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
    </body>
</html>
