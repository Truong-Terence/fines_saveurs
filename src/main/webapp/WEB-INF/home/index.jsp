<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Fines Saveurs | Administration</title>
    <style>
        <%@include file="../global.css"%>
        <%@include file="style.css"%>
    </style>

    <!-- Google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bentham&family=Lora:wght@500;600&family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous" defer></script>

</head>


<body id="homepage" class="overflow-hidden">

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
