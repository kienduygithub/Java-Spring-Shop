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
                    <h1 class="mt-4">Manage Products</h1>
                    <ol class="breadcrumb mb-4" style="padding-left: 3px;">
                        <li class="breadcrumb-item">
                            <a href="/admin">Dashboard</a>  
                        </li>
                        <li class="breadcrumb-item">
                            <a href="/admin/product">Products</a> 
                        </li>
                        <li class="breadcrumb-item active">
                            Delete
                        </li>
                    </ol>
                    <div class="mt-5">
                        <form:form method="post" action="/admin/product/delete"
                            modelAttribute="product"
                        >
                            <div class="row">
                                <div class="form-group col-12">
                                    <h3 class="mt-3">Delete a product with id = ${id}</h3>
                                    <hr />
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-12" style="display: none;">
                                    <label class="form-label">ID:</label>
                                    <form:input type="text" class="form-control"
                                        path="id" value="${id}"
                                    />
                                </div>
                                <div class="form-group">
                                    <div class="alert alert-danger" role="alert">
                                        Are you sure to delete this product?
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <button class="btn btn-danger" type="submit">CONFIRM</button>
                                    <a href="/admin/user" class="btn btn-success">BACK</a>
                                </div>
                            </div>
                        </form:form>
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