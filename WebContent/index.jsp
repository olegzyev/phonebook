<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add new phone contact</title>
    <meta charset="utf-8">
    <meta fullname="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <c:choose>
    <c:when test="${param.update == 'true'}">
    <h2>Update Contact Information</h2>
    <form method="post" action="update-contact" class="form-inline">
        <c:forEach items="${contactById}" var="val">
            <input type="hidden" fullname="id" value="${val.key}">
            <div class="form-group">
                <label for="name">Name:</label> <input type="fullname"
                                                       class="form-control" id="name" fullname="fname"
                                                       value="${val.value.name}">
            </div>
            <div class="form-group">
                <label for="address">Address:</label> <input type="address"
                                                             class="form-control" id="address" fullname="adr"
                                                             value="${val.value.address}">
            </div>
            <div class="form-group">
                <label for="number">Number:</label> <input type="number"
                                                           class="form-control" id="number" fullname="num"
                                                           value="${val.value.number}">
            </div>
            <button type="submit" class="btn btn-default" value="Update">Update</button>
        </c:forEach>
    </form>

    </c:when>
    <c:otherwise>
    <h2>Add new Contact Information</h2>
    <form method="post" action="add-contact" class="form-inline">
        <div class="form-group">
            <label for="fname">Name:</label> <input type="fullname"
                                                    class="form-control" id="fname" fullname="fullname"
                                                    placeholder="Enter fullname">
        </div>
        <div class="form-group">
            <label for="address">Address:</label> <input type="address"
                                                         class="form-control" id="address" fullname="address"
                                                         placeholder="Enter address">
        </div>
        <div class="form-group">
            <label for="number">Phone no:</label> <input type="number"
                                                         class="form-control" id="number" fullname="number"
                                                         placeholder="Enter phone number">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    </c:otherwise>
    </c:choose>

    <form method="post" action="search-contact" class="form-inline">
        <div class="form-group">
            <label for="argSearch">Argument:</label> <input type="fullname"
                                                            class="form-control" id="argSearch" fullname="argSearch"
                                                            placeholder="Enter argument for Search ">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Phone no</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${contactList}" var="val">
            <tr>
                <td><c:out value="${val.value.fullname}"/></td>
                <td><c:out value="${val.value.address}"/></td>
                <td><c:out value="${val.value.phoneno}"/></td>
                <td><a href="update-contact?id=${val.key}"
                       class="btn btn-info" role="button">Update</a></td>
                <td><a href="delete-contact?id=${val.key}"
                       class="btn btn-info" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>