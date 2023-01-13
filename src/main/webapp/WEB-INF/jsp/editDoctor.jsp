<%--
  Created by IntelliJ IDEA.
  User: tharaka
  Date: 2023-01-03
  Time: 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <title>Edit Doctor</title>
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" >
</head>
<body>

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

<div>

<% String success = request.getParameter("success");
  if(success != null){
    if(success.equals("true")){
%><h3 class="text-success fw-bold"> Edited Success </h3><%
} else {
%><h3 class="text-danger"> Edited Fail </h3><%
    }
  }
%>
</div>
<div class="container align-items-center align-content-center">


<form:form method="POST" action="/adminPanel/edit-save-doctor">
  <table >
    <tr>
      <td></td>
      <td><form:hidden  path="id" /></td>
    </tr>
    <tr>
      <td>First Name :</td>
      <td><form:input path="firstname" /></td>
    </tr>
    <tr>
      <td>Last Name :</td>
      <td><form:input path="lastname" /></td>
    </tr>
    <tr>
      <td>Email : </td>
      <td><form:input path="email"  /></td>
    </tr>
    <tr>
      <td>Contact :</td>
      <td><form:input path="contact" /></td>
    </tr>

    <tr>
      <td> </td>
      <td><input class="btn btn-secondary" type="submit" value="Edit Save" /></td>
    </tr>
  </table>
</form:form>

</div>
</body>
</html>
