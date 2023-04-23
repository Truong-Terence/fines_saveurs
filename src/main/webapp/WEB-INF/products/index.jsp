<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Fines Saveurs | Produits</title>
    <%@include file="../../styling/import-styles.jsp"%>
    <style>
        <%@include file="../../styling/global.css"%>
        <%@include file="style.css"%>
    </style>
</head>

<body id="products" class="pb-5">

<c:import url="../header/"/>

<div class="container">
    <div class="row my-5">
        <div class="col" id="breadcrumb">
            <p class="mb-0">Catégories <span>></span> Tous les produits</p>
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
            <a href="" class="ms-auto">
                <button class="button">Ajouter</button>
            </a>
        </div>
    </div>

    <div class="row my-5">
        <div class="col" id="grid-products">

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold small">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none uppercase bold smaller text-white">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold small">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none uppercase bold smaller text-white">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold small">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none uppercase bold smaller text-white">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold small">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none uppercase bold smaller text-white">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold small">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none uppercase bold smaller text-white">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold small">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none uppercase bold smaller text-white">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

        </div>
    </div>
</div>

</body>

</html>