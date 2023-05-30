<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Ajout de produit</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/form.css"%>
    </style>
</head>

<body id="admins" class="pb-5">

<c:import url="header.jsp"/>

<div class="container py-5">
    <div class="row">
        <div class="col">
            <h2 class="text-center">Nouvel administrateur</h2>
        </div>
    </div>
</div>

<div class="container">

    <div class="row">

        <div class="col-6 mx-auto">

            <form action="add-admin" method="post" enctype="multipart/form-data">

                <%-- firstname --%>
                <div class="mb-3">
                    <label for="firstname" class="form-label">Prénom *</label>
                    <input type="text" class="form-control" id="firstname" name="firstname" required>
                </div>

                <%-- lastname --%>
                <div class="mb-3">
                    <label for="lastname" class="form-label">Nom *</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" required>
                </div>

                <%-- email --%>
                <div class="mb-3">
                    <label for="email" class="form-label">Email *</label>
                    <input type="text" class="form-control" id="email" name="email" required>
                </div>

                <%-- password --%>
                <div class="mb-3">
                    <label for="password">Mot de passe *</label>
                    <input type="text" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="block-center d-block mt-5 button">Soumettre</button>

            </form>

        </div>

    </div>

</div>


</body>

</html>