<%-- 
    Document   : Page_Detail
    Created on : Dec 19, 2021, 9:43:54 PM
    Author     : long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="css/Page_ReadBook.css" rel="stylesheet" type="text/css"/>
        <title>Read Book Page</title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <a href="detail?bid=${book.bookID}" class="close">&times;</a><br>
                <h3 class="product-title text-center">${book.bookTitle}</h3>
                <p style="word-break: break-all">${book.content}</p>
            </div>
        </div>
    </body>
</html>
