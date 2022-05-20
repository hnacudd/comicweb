<%-- 
    Document   : Page_Create
    Created on : Dec 10, 2021, 10:23:51 AM
    Author     : long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="css/Page_Create.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Create Page</title>
        <script type="text/javascript" src="js/addjs.js"></script>
<!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
        <script src="js/loginvalidate.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="signup-form">
                <a href="Page_SignIn.jsp" class="close">&times;</a>
                <div id="signup-form_header">
                    <div class="logo">BOOK MANAGEMENT SYSTEM</div>
                </div>
                <div id="signup-form_content">
                    <form action="register" method="POST" class="form-login">
                        <div class="mb-3 vali">
                            <label for="exampleInputEmail1" class="form-label">Name: </label>
                            <input type="text" class="form-control" id="exampleInputEmail1" onblur="clear()" name="userName">
                            <span class="text-danger" id = "spanUserExits">${exitUser}</span>
                            
                        </div>
                        <div class="mb-3 vali">
                            <label for="exampleInputPassword1" class="form-label">Password</label>
                            <input type="password" class="form-control" name="password" id="exampleInputPassword1">
                            
                        </div>
                        <div class="mb-3 vali">
                            <label for="exampleInputPassword2" class="form-label">Comfirm Password</label>
                            <input type="password" class="form-control" name="rePassword" id="exampleInputPassword2">
                            
                        </div>
                        <button type="submit" class="btn btn-primary">Create Account</button>
                    </form>
                </div>
                <div id="signup-form_bottom">

                </div>
            </div>
        </div>
<!--        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>-->
    </body>
</html>
