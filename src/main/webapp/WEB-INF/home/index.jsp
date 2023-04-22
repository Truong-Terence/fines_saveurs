<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Fines Saveurs | Administration</title>
    <style>
        <%@include file="../global.css" %>
        <%@include file="style.css" %>
    </style>

    <!-- Google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bentham&family=Lora:wght@500;600&family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
</head>


<body id="homepage">

    <c:import url="../header/" />

    <div id="home" class="flex-column">

        <h1>Espace sécurisé</h1>

        <form action="#" method="post" class="flex-column text-center">
            <label for="login">Identifiant</label>
            <input name="" type="text" id="login">
            <label for="password">Mot de passe</label>
            <input name="" type="text" id="password">
            <input type="submit" value="Se connecter" class="block-center">
        </form>

    </div>

</body>

</html>
