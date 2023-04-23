<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Fines Saveurs | Fiche produit</title>
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

    <div class="container py-5">
        <div class="row">
            <div class="col">
                <h1 class="text-center">Fiche produit</h1>
            </div>
        </div>
    </div>

    <div class="container px-0 py-5">
        <div class="row justify-content-between">
            <div class="col-6 p-3">

                <dl class="row">

                    <dt class="col-sm-3 py-3">Nom</dt>
                    <dd class="col-sm-9 py-3 uppercase bold small">Tablette chocolat grand cru</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Marque</dt>
                    <dd class="col-sm-9 py-3 bold">Valrhona</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Référence</dt>
                    <dd class="col-sm-9 py-3">XXXXX</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Prix</dt>
                    <dd class="col-sm-9 py-3">10 €</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Conditionnement</dt>
                    <dd class="col-sm-9 py-3">100 gr.</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Description</dt>
                    <dd class="col-sm-9 py-3">Lorem ipsum dolor sit amet consectetur. Purus feugiat sit vulputate fusce convallis porta adipiscing cursus.</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Ingrédients</dt>
                    <dd class="col-sm-9 py-3">Lorem, ipsum, dolor, sit, amet, consectetur.</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Origine</dt>
                    <dd class="col-sm-9 py-3">Cacao de Madagascar transformé en France.</dd>
                    <hr>
                    <dt class="col-sm-3 py-3">Stock</dt>
                    <dd class="col-sm-9 py-3">10</dd>

                </dl>

            </div>
            
            <div class="col-5 img-container">
                <img src="../../images/4d0392165501469.640895c5b6092.jpg" alt="">
            </div>

        </div>
    </div>

    <div class="container-fluid position-absolute bottom-0 mx-auto">
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
                            <a href="#" class="underline-none">
                                <button class="button d-block ms-auto my-5">Supprimer</button>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>


</body>

</html>