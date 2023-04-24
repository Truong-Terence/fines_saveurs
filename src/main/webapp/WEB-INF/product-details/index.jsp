<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Fiche produit</title>
    <%@include file="../../styling/import-styles.jsp"%>
    <style>
        <%@include file="../../styling/global.css"%>
        <%@include file="style.css"%>
    </style>
</head>

<body id="products">

<c:import url="../header/"/>

    <div class="page">

        <div class="container py-5">
            <div class="row">
                <div class="col">
                    <h2 class="text-center">Fiche produit</h2>
                </div>
            </div>
        </div>

        <div class="container px-0 py-5" id="product-info">
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
                                <a href="#" class="underline-none">
                                    <button class="button d-block ms-auto my-5">Supprimer</button>
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>

</body>

</html>