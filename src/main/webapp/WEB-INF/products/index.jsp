<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Fines Saveurs | Produits</title>
    <style>
        <%@include file="../global.css"%>
        <%@include file="style.css"%>
    </style>

    <!-- Google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bentham&family=Lora:wght@500;600&family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
          rel="stylesheet">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"
            defer></script>
</head>

<body id="products" class="pb-5">

<c:import url="../header/"/>

<div class="container">
    <div class="row my-5">
        <div class="col" id="breadcrumb">
            <p class="mb-0">Produits <span>></span> Tous les produits</p>
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
                    <p class="uppercase bold smaller">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold smaller">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold smaller">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold smaller">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold smaller">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none">Détails</a></p>
                        <p class="mb-0">Stock : 10</p>
                    </div>
                </div>
                <div class="col-right">
                    <img src="<c:url value="../../images/4d0392165501469.640895c5b6092.jpg" />" alt="">
                </div>
            </div>

            <div class="product-card">
                <div class="col-left">
                    <p class="uppercase bold smaller">Tablette chocolat grand cru</p>
                    <p class="bold">Valrhona</p>
                    <p>Ref. XXXXX</p>
                    <p>10 €</p>
                    <p>100 gr.</p>
                    <div class="aligned">
                        <p class="mb-0"><a href="product-details" class="underline-none">Détails</a></p>
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