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
            <li><a href="/notes"><span class="glyphicon glyphicon-log-star"></span> Notes</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/friend"><span class="glyphicon glyphicon-log-star"></span> Friends</a></li>
        </ul>
         <a class="navbar-brand" href="#">
      <img src="https://assets.stickpng.com/images/585e4bf3cb11b227491c339a.png" alt="Avatar" style="width:35px; height: 35px;" class="rounded-pill" align="center"> ${user.mail}
    </a>
    </div>
</nav>

<br>
<div class="container">
    <h3>Added Teachers</h3>
    <c:if test="${not empty teacherList}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Subject</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="t" items="${teacherList}">
                <tr>
                    <td>${t.name}</td>
                    <td>${t.subject}</td>
                    <td><a href="/teacher/update?id=${t.id}">Update</a></td>
                    <td><a href="/teacher/${t.id}/delete">Delete</a></td>
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
    <c:if test="${empty teacherList}">
        <br>
        <p>No teachers addded here.</p>
        <br>
    </c:if>
</div>

<div class="container" style="margin-top: 50px">
    <h3>Add a new teacher</h3>

    <%--@elvariable id="friend" type="java"--%>
    <form:form action="/teacher/save" method="post" modelAttribute="teacher">
        <div class="form-group">
            ID: ${user.id}
            <form:hidden path="id" class="form-control"/>
        </div>
        <div class="form-group">
            Name:
            <form:input path="name" class="form-control"/>
        </div>
        <div class="form-group">
            Subject:
            <form:input path="subject" class="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" id="submit" class="btn btn-dar" value="Save">
        </div>
    </form:form>
</div>
</body>
</html>