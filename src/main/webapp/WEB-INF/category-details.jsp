<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Fiche catégorie</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/product-details.css"%>
    </style>
</head>

<body>
<c:import url="header.jsp"/>

<div class="page">

    <div class="container py-5">
        <div class="row">
            <div class="col">
                <h2 class="text-center">Fiche catégorie</h2>
            </div>
        </div>
    </div>

    <div class="container px-0 py-3" id="product-info">
        <div class="row justify-content-between">
            <div class="col-6 p-3">
                <dl class="row">
                    <dt class="col-sm-3 py-3">Nom</dt>
                    <dd class="col-sm-9 py-3 uppercase bold small"> ${category.name} </dd>
                    <hr>
                </dl>
            </div>
        </div>
    </div>

    <div class="container-fluid mx-auto">
        <div class="row">
            <div class="col">

                <div class="container">
                    <div class="row">


                        <div class="col">
                            <a href="#" class="underline-none">
                                <button class="button d-block my-5">Éditer</button>
                            </a>
                        </div>

                        <div class="col">
                            <form method="POST" action="${pageContext.request.contextPath}delete-category">
                                <input type="hidden" name="id" value="${category.id}">
                                <input type="hidden" name="_method" value="DELETE">
                                <button class="button d-block ms-auto my-5" type="submit">Supprimer</button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

</body>

</html>