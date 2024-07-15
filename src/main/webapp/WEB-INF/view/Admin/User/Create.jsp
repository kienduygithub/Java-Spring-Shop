<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User (Admin)</title>
        <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <form:form method="post" action="/admin/user/handle-create"
            modelAttribute="newUser"
        >
            <div class="row mx-auto">
                <div class="form-group col-12">
                    <h3 class="mt-3">Create a user</h3>
                    <hr />
                </div>
            </div>
            <div class="row mb-lg-2 mx-auto">
                <div class="form-group col-12 col-lg-6 mb-2 mb-lg-0">
                    <label class="form-label">Email:</label>
                    <form:input type="email" class="form-control"
                        path="email"
                    />
                </div>
                <div class="form-group col-12 col-lg-6 mb-2 mb-lg-0">
                    <label class="form-label">Password:</label>
                    <form:input type="password" class="form-control"
                        path="password"
                    />
                </div>
            </div>
            <div class="row mb-lg-2 mx-auto">
                <div class="form-group col-12 col-lg-6 mb-2 mb-lg-0">
                    <label class="form-label">Phone number:</label>
                    <form:input type="text" class="form-control"
                        path="phone"
                    />
                </div>
                <div class="form-group col-12 col-lg-6 mb-2 mb-lg-0">
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
                    <button class="btn btn-primary w-100" type="submit">CREATE</button>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
