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
        body{
                background-color: rgb(230, 204, 255);
            }
    </style>
</head>
<body>

<div class="container">
    <div class="alert alert-success">
        <strong>Successfully registered!</strong> Welcome ${user.name}
    </div>
    <div class="btn-group">
        <a href="/" class="btn btn-info" role="button">Login</a>
    </div>
</div>
</body>
</html>