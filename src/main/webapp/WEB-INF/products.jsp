<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Produits</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/products.css"%>
    </style>
</head>

<body id="products" class="pb-5">

<c:import url="header.jsp"/>

<div class="container">
    <div class="row my-5">
        <div class="col" id="breadcrumb">
            <p class="mb-0">
                <a href="${pageContext.request.contextPath}/secured/categories">Catégories</a>
                <span>></span>
                <c:choose>
                    <c:when test="${category == null}"> Tous les produits </c:when>
                    <c:otherwise> <span class="capitalize"> ${category.name} </span> </c:otherwise>
                </c:choose>
            </p>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <form action="">
                <div class="mb-3 position-relative">
                    <input type="text" placeholder="Rechercher un produit">
                    <input type="submit" value="" class="position-absolute end-0">
                </div>
            </form>
        </div>
        <div class="col text-end">
            <a href="${pageContext.request.contextPath}/secured/add-product" class="ms-auto">
                <button class="button">Ajouter</button>
            </a>
        </div>
    </div>

    <div class="row my-5">
        <div class="col" id="grid-products">

            <c:forEach var="prod" items="${products}">

                <div class="product-card overflow-hidden">
                    <div class="col-left">
                        <p class="uppercase bold small"> ${prod.name} </p>
                        <p class="bold"> ${prod.brand} </p>
                        <p>Ref. ${prod.reference} </p>
                        <p> ${prod.price} €</p>
                        <p> ${prod.conditioning} </p>
                        <div class="aligned">
                            <p class="mb-0"><a href="${pageContext.request.contextPath}/secured/product-details?id=${prod.id}" class="underline-none uppercase bold smaller text-white">Détails</a></p>
                            <p class="mb-0">Stock : ${prod.stock} </p>
                        </div>
                    </div>
                    <div class="col-right">
                        <c:choose>
                            <c:when test="${prod.imageUrl.length() == 0}">
                                <img src="/images/placeholder.jpg" alt="">
                            </c:when>
                            <c:otherwise>
                                <img src="image?file=${pageContext.request.contextPath}${prod.imageUrl}" alt="">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>
</div>

</body>

</html>