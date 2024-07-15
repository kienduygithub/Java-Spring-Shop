<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin User Home</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row mt-5">
            <div class="form-group d-flex justify-content-between">
                <h3 class="m-0">Table users</h3>
                <a href="/admin/user/create" class="btn btn-primary fw-bold">CREATE A USER</a>
            </div>
            <div class="form-group">
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th class="col-1">ID</th>
                            <th class="col-3">Email</th>
                            <th class="col-3">Full Name</th>
                            <th class="col-5">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <th class="align-middle">${user.id}</th>
                                <td class="align-middle">${user.email}</td>
                                <td class="align-middle">${user.fullName}</td>
                                <td class="d-flex align-items-center gap-2">
                                    <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                                    <button class="btn btn-warning text-white">Update</button>
                                    <button class="btn btn-danger">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>