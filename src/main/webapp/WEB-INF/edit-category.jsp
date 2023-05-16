<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Edition de catégorie</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
    </style>
</head>

<body>

<c:import url="header.jsp"/>

<div class="container py-5">
    <div class="row">
        <div class="col">
            <h2 class="text-center">Edition du catégorie</h2>
        </div>
    </div>
</div>

<div class="container">

    <div class="row">

        <div class="col-6 mx-auto">

            <form action="${pageContext.request.contextPath}/secured/edit-category?id=${category.id}" method="post">

                <div class="mb-3">
                    <label for="name" class="form-label">Nom du produit</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Nom de la catégorie" required value="${category.name}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>

            </form>

        </div>

    </div>

</div>


</body>

</html>