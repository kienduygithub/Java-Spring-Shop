<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User (Admin)</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <form:form method="post" action="/admin/user/update"
            modelAttribute="user"
        >
            <div class="row mx-auto">
                <div class="form-group col-12">
                    <h3 class="mt-3">Update a user</h3>
                    <hr />
                </div>
            </div>
            <div class="row mb-lg-2 mx-auto">
                <div class="form-group col-12 mb-2" style="display: none;">
                    <label class="form-label">ID:</label>
                    <form:input type="text" class="form-control"
                        path="id"
                    />
                </div>
                <div class="form-group col-12 mb-2">
                    <label class="form-label">Email:</label>
                    <form:input type="email" class="form-control"
                        path="email" disabled="true"
                    />
                </div>
            </div>
            <div class="row mx-auto">
                <div class="form-group col-12 mb-2">
                    <label class="form-label">Phone number:</label>
                    <form:input type="text" class="form-control"
                        path="phone"
                    />
                </div>
                <div class="form-group col-12 mb-2">
                    <label class="form-label">Full Name:</label>
                    <form:input type="text" class="form-control"
                        path="fullName"
                    />
                </div>     
            </div>
            <div class="row mx-auto">
                <div class="form-group col-12">
                    <label class="form-label">Address:</label>
                    <form:input type="text" class="form-control"
                        path="address"
                    />
                </div>
                <div class="form-group col-12 mt-3">
                    <button class="btn btn-warning text-white w-100" type="submit">UPDATE</button>
                    <a href="/admin/user" class="btn btn-success mt-3 w-100">BACK</a>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
