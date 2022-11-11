<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link href="../../css/styles.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>WebAT</title>
        <style>
            .jumbotron {
                background-color: rgb(230, 204, 255);
                color: black;
                font-family: Helvetica;

            }
            
            body{
                background-color: rgb(230, 204, 255);
            }
        </style>
    </head>
    <body>
        <div class="jumbotron text-center" style="margin-bottom: 0">
                    <div style="font-family: Calibri;font-weight: bold;font-size: 45px;color: #32464e;text-align: center;margin-left: -162px;">
                        Login
                    </div>
                </div>
        <div class="container" style="margin-top: 250px;">
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <strong>Invalid Login.</strong> ${error}
                </div>
            </c:if>

             <form action="/user/login" style="margin-left: 350px" method="post">
                        <div class="form-group">
                            <label style="font-size: 20px;color: black;font-family: Arial"
                                    E-mail:>
                            </label>
                            <input type="email" style="width: 300px;border-radius: 10px" placeholder="E-mail:" name="mail" required>
                        </div>
                        <div class="form-group">
                            <label style="font-size: 20px;color: black;font-family: Arial"
                                    Password:>
                            </label>
                            <input type="password" style="width: 300px;border-radius: 10px" placeholder="Password:" name="password" required>
                        </div>
                        <div class="btn-group">
                            <button type="submit" style="margin-left: 110px" class="btn btn-info">Login</button>
                        </div>
                        <div class="btn-group">
                            <a href="/user" class="btn btn-default" role="button">SignUp</a>
                        </div>
             </form>
        </div>
    </body>
</html>