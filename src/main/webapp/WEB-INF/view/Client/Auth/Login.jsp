<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Register - Laptopshop</title>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content" style="margin-bottom: 5px;">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-7">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">Welcome</h3></div>
                                <div class="card-body">
                                    <form:form action="/login" method="post"
                                        modelAttribute="user"
                                    >
                                        <div class="row mb-3">
                                            <div class="col-md-12">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <form:input class="form-control" type="email" placeholder="Enter your email"
                                                        path="email"
                                                    />
                                                    <label>Email</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row mb-md-3">
                                            <div class="col-md-12">
                                                <div class="form-floating mb-3 mb-md-0">
                                                    <form:input class="form-control" type="password" placeholder="Create a password" 
                                                        path="password"
                                                    />
                                                    <label>Password</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-md-12" style="margin-left: 2px;">
                                                <input type="checkbox" class="form-check-input" id="rememberPassword"/>
                                                <label for="rememberPassword" class="form-check-label">Remember Password</label>
                                            </div>
                                        </div>
                                        <div class="mb-0">
                                            <div class="d-grid">
                                                <button class="btn btn-primary btn-block" type="submit">
                                                    LOGIN
                                                </button>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                                <div class="card-footer text-center py-3">
                                    <div class="small"><a href="/register">Don't have an account? Go to register</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
