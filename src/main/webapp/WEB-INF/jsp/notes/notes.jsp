<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
         <ul class="nav navbar-nav navbar-right">
            <li><a href="/teacher"><span class="glyphicon glyphicon-log-star"></span> Teacher</a></li>
        </ul>
         <ul class="nav navbar-nav navbar-right">
            <li><a href="/friend"><span class="glyphicon glyphicon-log-star"></span> Friends</a></li>
        </ul>
         <a class="navbar-brand" href="#">
      <img src="https://assets.stickpng.com/images/585e4bf3cb11b227491c339a.png" alt="Avatar Logo" style="width:35px; height: 35px;" class="rounded-pill" align="center"> ${user.mail}
    </a>
    </div>
</nav>

<br>
<div class="container">
    <h3>Your Notes</h3>
    <c:if test="${not empty notesList}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Title</th>
                <th>Descripton</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="n" items="${notesList}">
                <tr>
                    <td>${n.title}</td>
                    <td>${n.description}</td>
                    <td><a href="/notes/update?id=${n.id}">Update</a></td>
                    <td><a href="/notes/${n.id}/delete">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${not empty erro}">
        <div class="alert alert-danger">
            <strong>Erro!</strong> ${erro}
        </div>
    </c:if>
    <c:if test="${empty notesList}">
        <br>
        <p>No notes addded here.</p>
        <br>
    </c:if>
</div>

<div class="container" style="margin-top: 50px">
    <h3>Add a new note</h3>

    <%--@elvariable id="friend" type="java"--%>
    <form:form action="/notes/save" method="post" modelAttribute="notes">
        <div class="form-group">
            ID: ${user.id}
            <form:hidden path="id" class="form-control"/>
        </div>
        <div class="form-group">
            Title:
            <form:input path="title" class="form-control"/>
        </div>
        <div class="form-group">
            Description:
            <form:input path="description" class="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" id="submit" class="btn btn-dar" value="Save">
        </div>
    </form:form>
</div>
</body>
</html>