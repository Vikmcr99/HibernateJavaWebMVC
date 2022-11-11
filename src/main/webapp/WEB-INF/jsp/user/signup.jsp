<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
            color: #FFFFFF;
        }
        
        body{
                background-color: rgb(230, 204, 255);
            }
    </style>
</head>
<body>
<div class="jumbotron text-center">
    <div style="font-family: Calibri;font-weight: bold;font-size: 45px;color: #32464e;text-align: center;margin-left: -162px;">
        SignUp
    </div>
</div>
<div class="container">
    <form action="/user/adduser" style="margin-left: 350px" method="post">
        <div class="form-group">
            <input type="text" class="form-control" style="width: 300px;border-radius: 10px"
                   placeholder="Name:" name="name" required>
        </div>
        <div class="form-group">
            <input type="email" class="form-control" style="width: 300px;border-radius: 10px"
                   placeholder="E-mail:" name="mail" required>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" style="width: 300px;border-radius: 10px"
                   placeholder="Password:" name="password" required>
        </div>
        <div class="btn-group">
            <button type="submit" style="margin-left: 110px" class="btn btn-info" align ="center">SignUP</button>
        </div>
       
    </form>
</div>
</body>
</html>