<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
    <meta name="author" content="Hỏi Dân IT" />
    <title>Create Users (Admin)</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page="../Layout/Header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../Layout/Sidebar.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Manage Users</h1>
                    <ol class="breadcrumb mb-4" style="padding-left: 3px;">
                        <li class="breadcrumb-item">
                            <a href="/admin">Dashboard</a>  
                        </li>
                        <li class="breadcrumb-item active">
                            Users 
                        </li>
                    </ol>
                    <div class="mt-5">
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
                                        <li class="list-group-item">Role: ${user.role.name}</li>
                                        <li class="list-group-item">Avatar: 
                                            <img src="/images/avatar/${user.avatar}" alt="avatar"
                                                style="max-height: 250px;"
                                            >
                                        </li>
                                    </ul>
                                </div>
                                <a href="/admin/user" class="btn btn-success mt-2">BACK</a>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="../Layout/Footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="/js/scripts.js"></script>
</body>

</html>