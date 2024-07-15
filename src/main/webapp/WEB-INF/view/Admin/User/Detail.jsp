<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details ${id}</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="form-group">
                <h3>User details with id = ${id}</h3>
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <div class="card" style="width: 60%;">
                    <div class="card-header">
                        User information
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">ID: ${user.id}</li>
                        <li class="list-group-item">Email: ${user.email}</li>
                        <li class="list-group-item">FullName: ${user.fullName}</li>
                        <li class="list-group-item">Address: ${user.address}</li>
                        <li class="list-group-item">Phone number: ${user.phone}</li>
                    </ul>
                </div>
                <a href="/admin/user" class="btn btn-success mt-2">Back</a>
            </div>
        </div>
    </div>
</body>
</html>