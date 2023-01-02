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

<h1>Edit Employee</h1>
<form:form method="POST" action="/edit-save-doctor">
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
      <td><form:input path="name"  /></td>
    </tr>
    <tr>
      <td>Contact :</td>
      <td><form:input path="contact" /></td>
    </tr>

    <tr>
      <td> </td>
      <td><input type="submit" value="Edit Save" /></td>
    </tr>
  </table>
</form:form>
