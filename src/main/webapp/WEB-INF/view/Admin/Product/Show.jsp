<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
    <meta name="author" content="Hỏi Dân IT" />
    <title>Dashboard - Hỏi Dân IT</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page="../Layout/Header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../Layout/Sidebar.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Manage Products</h1>
                    <ol class="breadcrumb mb-4" style="padding-left: 3px;">
                        <li class="breadcrumb-item">
                            <a href="/admin">Dashboard</a>  
                        </li>
                        <li class="breadcrumb-item active">
                            Product
                        </li>
                    </ol>
                    <div>
                        <div class="row mt-5">
                            <div class="form-group d-flex justify-content-between">
                                <h3 class="m-0">Table Products</h3>
                                <a href="/admin/product/create" class="btn btn-primary fw-bold">CREATE A PRODUCT</a>
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
                                            <th class="col-3">Name</th>
                                            <th class="col-2">Price</th>
                                            <th class="col-2">Factory</th>
                                            <th class="col-4">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- <c:forEach var="user" items="${users}">
                                            <tr>
                                                <th class="align-middle">${user.id}</th>
                                                <td class="align-middle">${user.email}</td>
                                                <td class="align-middle">${user.fullName}</td>
                                                <td class="align-middle">${user.role.name}</td>
                                                <td class="d-flex align-items-center gap-2">
                                                    <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                                                    <a href="/admin/user/update/${user.id}" class="btn btn-warning text-white">Update</a>
                                                    <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach> -->
                                    </tbody>
                                </table>
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