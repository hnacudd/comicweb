<%-- 
    Document   : Page_Admin
    Created on : Dec 19, 2021, 7:54:05 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Form admin kiểu 1</title>
        <!--link css-->
        <link href="css/Page_Admin.css" rel="stylesheet" type="text/css"/>
        <!--link js-->
        <script src="js/admin.js"></script>
        <!--font awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    </head>

    <body>
        <div class="container">
            <!--phần navbar menu bên trái-->
           <%@include file="Page_Navigation.jsp" %>
            <div class="main">
               <%@include file="Page_HeaderAdmin.jsp" %>
               
            </div>
        </div>
    </body>

</html>
