<%-- 
    Document   : Page_Navigation
    Created on : Dec 19, 2021, 8:18:08 PM
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
        <div class="navigation">
                <ul>
                    <li>
                        <a href="adminController">
                            <span class="icon">
                                <i class="fa fa-book" aria-hidden="true"></i>
                            </span>
                            <span class="title"><h2>Admin System</h2></span>
                        </a>
                    </li>
                    <li>
                        <a href="adminController">
                            <span class="icon">
                                <i class="fa fa-home" aria-hidden="true"></i>
                            </span>
                            <span class="title">Dashboard</span>
                        </a>

                    </li>
                    <li>
                        <a href="addBook"><span class="icon">
                                <i class="fa fa-plus" aria-hidden="true"></i>
                            </span>
                            <span class="title">Add Book</span></a>

                    </li>
                    <li>
                        <a href="u1"><span class="icon">
                                <i class="fa fa-pencil" aria-hidden="true"></i>
                            </span>
                            <span class="title">Edit Book</span>
                        </a>

                    </li>
                   
                    <li>
                        <a href="LogoutController"> <span class="icon">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                            </span>
                            <span class="title">Signout</span>
                        </a>

                    </li>
                </ul>
            </div>
    </body>
</html>
