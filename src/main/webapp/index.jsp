<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
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
                            <a href="home" class="nav-link active" >Home</a>
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

    <form action="register" method="post">
        <table>
            <tr>
                <td>First Name</td><td><input type="text" name="firstname"/></td>
            </tr>
            <tr>
                <td>Last Name</td><td><input type="text" name="lastname"/></td>
            </tr>
            <tr>
                <td>Email</td><td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>Contact</td><td><input type="text" name="contact"/></td>
            </tr>
            <tr>
                <td></td><td><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form>

</body>
</html>

