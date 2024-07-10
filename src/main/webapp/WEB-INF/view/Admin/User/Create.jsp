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
        <form:form class="row" method="post" action="/admin/user/create"
            modelAttribute="newUser"
        >
            <div class="form-group">
                <h3 class="mt-3 text-center">Create a user</h3>
                <hr />
            </div>
            <div class="form-group col-12 col-md-6">
                <label class="form-label">Email:</label>
                <form:input type="email" class="form-control"
                    path="email"
                />
            </div>
            <div class="form-group col-12 col-md-6">
                <label class="form-label">Password:</label>
                <form:input type="password" class="form-control"
                    path="password"
                />
            </div>
            <div class="form-group col-12 col-md-6">
                <label class="form-label">Phone number:</label>
                <form:input type="text" class="form-control"
                    path="phone"
                />
            </div>
            <div class="form-group col-12 col-md-6">
                <label class="form-label">Full Name:</label>
                <form:input type="text" class="form-control"
                    path="fullName"
                />
            </div>     
            <div class="form-group col-12">
                <label class="form-label">Address:</label>
                <form:input type="text" class="form-control"
                    path="address"
                />
            </div>
            <div class="form-group col-12 mt-4">
                <button class="btn btn-primary w-100" type="submit">Submit</button>
            </div>
        </form:form>
    </div>
</body>
</html>
