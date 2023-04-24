<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <%@include file="../../styling/import-styles.jsp"%>
    <style>
        <%@include file="../../styling/global.css" %>
        <%@include file="style.css"%>
    </style>
</head>


<body>

    <div class="container-fluid fixed-top bg-beige">
        <div class="row">
            <div class="col">

                <div class="container">
                    <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top margins">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="home">Fines Saveurs</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                                    <li class="nav-item ms-3" id="categories-li">
                                        <a class="nav-link" href="categories">Catégories</a>
                                    </li>
                                    <li class="nav-item ms-3" id="products-li">
                                        <a class="nav-link" href="products">Produits</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>

            </div>
        </div>
    </div>

</body>