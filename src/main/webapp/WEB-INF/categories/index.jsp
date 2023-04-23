<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <title>Fines Saveurs | Catégories</title>
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

<body id="categories" class="pb-5">

<c:import url="../header/" />

<div class="container">
  <div class="row flex-column justify-content-center">
    <div class="col d-flex flex-column justify-content-around">
      <h1 class="text-center my-5">Catégories</h1>
      <div class="square-grid mt-3">
        <div class="square text-center d-flex justify-content-center align-items-center"><p></p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Cafés</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Chocolaterie</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Boissons</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Spécialités <br> salées</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Epices</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Condiments</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Gâteaux <br>& douceurs</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Thés <br>& infusions</p></div>
        <div class="square text-center d-flex justify-content-center align-items-center"><p>Fruits secs</p></div>
      </div>
      <a href="products" class="underline-none">
        <button class="button d-block mx-auto">Tous les produits</button>
      </a>
    </div>
  </div>
</div>

</body>

</html>
