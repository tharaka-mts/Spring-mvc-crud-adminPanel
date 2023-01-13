<%--
  Created by IntelliJ IDEA.
  User: tharaka
  Date: 2023-01-05
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Petowner</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" >
</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg shadow">
        <div class="container mt-2 mb-2">
            <a class="navbar-brand" href="#">AdminPanel</a>
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
                        <a href="doctors" class="nav-link" >Doctors</a>
                    </li>
                    <li class="nav-item">
                        <a href="petowners" class="nav-link" >Pet Owners</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>



<div class="container mt-5 d-flex align-items-center justify-content-center">

    <%--  Success Message  --%>

    <% String success = request.getParameter("success");
        if(success != null){
            if(success.equals("true")){
    %><h3 class="text-success fw-bold"> Successfully Added </h3><%
} else {
%><h3 class="text-danger"> Failed </h3><%
        }
    }
%>
</div>

<div class="container mt-5 align-items-center w-50">
    <h1>Add PetOwner</h1>
    <form action="add-owner" method="post">
        <div class="form-group mt-3">
            <label for="firstname">First Name</label>
            <input name="firstname" type="text" class="form-control" id="firstname" aria-describedby="emailHelp" placeholder="Enter Firstname" required>
        </div>
        <div class="form-group mt-3">
            <label for="lastname">Last Name</label>
            <input name="lastname" type="text" class="form-control" id="lastname" aria-describedby="emailHelp" placeholder="Enter Lastname" required>
        </div>
        <div class="form-group mt-3">
            <label for="Email">Email address</label>
            <input name="email" type="email" class="form-control" id="Email" aria-describedby="emailHelp" placeholder="Email" required>
        </div>
        <div class="form-group mt-3">
            <label for="contact">Contact</label>
            <input name="contact" type="text" class="form-control" id="contact" aria-describedby="emailHelp" placeholder="Contact" required>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Submit</button>
    </form>
</div>

</body>
</html>
