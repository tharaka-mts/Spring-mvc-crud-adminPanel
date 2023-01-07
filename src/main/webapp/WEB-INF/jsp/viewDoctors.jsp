<%--
  Created by IntelliJ IDEA.
  User: tharaka
  Date: 2022-12-31
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Doctors</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" >
</head>
<body>

<%--Navbar--%>

<div>
    <nav class="navbar navbar-expand-lg shadow">
        <div class="container mt-2 mb-2">
            <a class="navbar-brand" href="home">AdminPanel</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu" aria-controls="navMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse ms-3" id="navMenu">
                <ul class="nav nav-pills nav-fill ms-auto">
                    <li class="nav-item">
                        <a href="home" class="nav-link" >Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="hospitals" class="nav-link" >Hospitals</a>
                    </li>
                    <li class="nav-item">
                        <a href="doctors" class="nav-link active" >Doctors</a>
                    </li>
                    <li class="nav-item">
                        <a href="petowners" class="nav-link" >Pet Owners</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
</div>

<div class="container my-3">

    <%--  Success Message  --%>

    <% String success = request.getParameter("success");
        if(success != null){
            if(success.equals("true")){
    %><h3 class="text-success fw-bold"> Deleted Success </h3><%
        } else {
    %><h3 class="text-danger"> Deleted Fail </h3><%
        }
    }
%>
    <h1 class="mt-4">Doctors</h1>

    <a href = "addDoctor" class="btn btn-primary btn-sm my-3"> Add Doctor </a>

    <table border="1" class = "table table-striped table-responsive-md">
        <thead>
        <tr>
            <th>
                Id
            </th>
            <th>
                First Name
            </th>
            <th>
                Last Name
            </th>
            <th> Email </th>
            <th> Contact </th>
            <th> Action </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="doctor" items="${list}">
        <tr>
            <td>${doctor.id}</td>
            <td>${doctor.firstname}</td>
            <td>${doctor.lastname}</td>
            <td>${doctor.email}</td>
            <td>${doctor.contact}</td>
            <td>
                <a href="edit-doctor/${doctor.id}" class="btn btn-dark">Edit</a>
                <a href="delete-doctor/${doctor.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
        </tbody>
        </c:forEach>
    </table>
</div>

</body>
</html>
