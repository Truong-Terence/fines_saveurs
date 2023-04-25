<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Administration</title>
    <%@include file="../../styling/import-styles.jsp"%>
    <style>
        <%@include file="../../styling/global.css"%>
        <%@include file="style.css"%>
    </style>
</head>


<body id="homepage">

    <c:import url="../header/" />

    <div class="container h-100">
        <div class="row h-100">
            <div class="col-12 mx-auto d-flex flex-column justify-content-center align-items-center">

                <h1 class="text-center mb-5">Espace sécurisé</h1>

                <form action="#" method="post" class="text-center mt-5">
                    <label for="login" class="mb-1">Identifiant</label>
                    <input name="" type="email" id="login">
                    <label for="password" class="mt-5 mb-1">Mot de passe</label>
                    <input name="" type="password" id="password" class="mb-5">
                    <input type="submit" value="Se connecter" class="block-center d-block m-auto mt-5 button">
                </form>

            </div>
        </div>
    </div>


</body>

</html>
