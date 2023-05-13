<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Edition de produit</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/add-product.css"%>
    </style>
</head>

<body id="products" class="pb-5">

<c:import url="header.jsp"/>

<div class="container py-5">
    <div class="row">
        <div class="col">
            <h2 class="text-center">Edition du produit</h2>
        </div>
    </div>
</div>

<div class="container">

    <div class="row">

        <div class="col-6 mx-auto">

            <form action="add-product" method="post" enctype="multipart/form-data">

                <%-- name --%>
                <div class="mb-3">
                    <label for="product-name" class="form-label">Nom du produit</label>
                    <input type="text" class="form-control" id="product-name" name="product-name" placeholder="Nom du produit" value="${product.name}">
                </div>

                <%-- brand --%>
                <div class="mb-3">
                    <label for="brand" class="form-label">Marque</label>
                    <input type="text" class="form-control" id="brand" name="brand" value="${product.brand}">
                </div>

                <%-- stock --%>
                <div class="mb-3">
                    <label for="stock" class="form-label">Stock</label>
                    <input type="number" class="form-control" id="stock" name="stock" value="${product.stock}">
                </div>

                <%-- description --%>
                <div class="mb-3">
                    <label for="description">Description</label>
                    <textarea class="form-control" placeholder="Leave a comment here" id="description" style="height: 100px" name="description">${product.description}</textarea>
                </div>

                <%-- ingredients --%>
                <div class="mb-3">
                    <label for="ingredients">Ingrédients</label>
                    <textarea class="form-control" placeholder="Leave a comment here" id="ingredients" style="height: 100px" name="ingredients">${product.ingredient}</textarea>
                </div>


                <%-- conditioning --%>
                <div class="mb-3">
                    <label for="conditioning" class="form-label">Conditionnement</label>
                    <input type="text" class="form-control" id="conditioning" name="conditioning" value="${product.conditioning}">
                </div>

                <%-- origin --%>
                <div class="mb-3">
                    <label for="origin" class="form-label">Origine</label>
                    <input type="text" class="form-control" id="origin" name="origin" value="${product.origin}">
                </div>

                <%-- price --%>
                <div class="mb-3">
                    <label for="price" class="form-label">Prix</label>
                    <input type="number" step=".01" class="form-control" id="price" name="price" value="${product.price}">
                </div>

                <%-- Category --%>
                <div class="mb-3">
                    <select name="category" class="form-select">
                        <option value="" disabled selected> Choisir une catégorie </option>
                        <c:forEach var="cat" items="${categories}">
                            <option value="${cat.id}" ${cat.id == product.category.id ? "selected" : ""}> ${cat.name} </option>
                        </c:forEach>
                    </select>
                </div>

                <%-- image --%>
                <div class="mb-3">
                    <label for="file-selector" class="form-label">Image</label>
                    <input class="form-control" type="file" id="file-selector" accept="image/jpg, image/jpeg" name="file">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>

            </form>

        </div>

    </div>

</div>


</body>

</html>