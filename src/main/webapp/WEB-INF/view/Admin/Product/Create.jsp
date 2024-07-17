<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Product</title>
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
                        <li class="breadcrumb-item active">
                            Products
                        </li>
                    </ol>
                    <form:form action="/admin/product/create" method="POST" enctype="multipart/form-data"
                        modelAttribute="newProduct"
                    >
                        <div class="row">
                            <div class="form-group">
                                <h3>Create a new product</h3>
                                <hr/>
                            </div>
                            <div class="form-group col-6 mb-2">
                                <label class="form-label">Name: </label>
                                <form:input type="text" class="form-control" 
                                    path="name"
                                />
                            </div>
                            <div class="form-group col-6 mb-2">
                                <label class="form-label">Price: </label>
                                <form:input type="text" class="form-control" 
                                    path="price"
                                />
                            </div>
                            <div class="form-group col-12 mb-2">
                                <label class="form-label">Detail description: </label>
                                <form:textarea rows="1" class="form-control"
                                    path="detailDesc"
                                ></form:textarea>
                            </div>
                            <div class="form-group col-12 mb-2">
                                <label class="form-label">Short description: </label>
                                <form:input type="text" class="form-control" 
                                    path="shortDesc"
                                />
                            </div>
                            <div class="form-group col-4 mb-2">
                                <label class="form-label">Quantity:</label>
                                <form:input type="number" min="0" class="form-control" 
                                    path="quantity"
                                />
                            </div>
                            <div class="form-group col-4 mb-2">
                                <label class="form-label">Factory:</label>
                                <form:select class="form-select"
                                    path="factory"
                                >
                                    <form:option value="MACBOOK">MacBook</form:option>
                                    <form:option value="DELL">Dell</form:option>
                                    <form:option value="LENOVO">Lenovo</form:option>
                                </form:select>
                            </div>
                            <div class="form-group col-4 mb-2">
                                <label class="form-label">Target:</label>
                                <form:input type="text" class="form-control" 
                                    path="target"
                                />
                            </div>
                            <div class="form-group col-6 mb-4">
                                <label for="imgProductFile" class="form-label">Image:</label>
                                <input type="file" class="form-control"
                                    id="imgProductFile" accept=".png, .jpg, .jpeg"
                                    name="imgProductFile"
                                >
                            </div>
                            <div class="form-group col-6 mb-4">
                                <img style="max-height: 240px; width: 100%; display: none;"
                                    alt="product preview" id="productPreview"
                                />
                            </div>
                            <div class="form-group col-12">
                                <button class="btn btn-primary w-100 mb-2" type="submit">CREATE</button>
                                <a href="/admin/product" class="btn btn-success w-100">BACK</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </main>
            <jsp:include page="../Layout/Footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="/js/scripts.js"></script>
    <script>
        $(document).ready(
            () => {
                const imgProductFile = $("#imgProductFile");
                let productPreview = $("#productPreview");
                let imgURL;
                imgProductFile.change((e) => {
                    imgURL = URL.createObjectURL(e.target.files[0]);
                    productPreview.attr("src", imgURL);
                    productPreview.css({"display": "block"});
                })
            }
        )
    </script>
</body>
</html>
