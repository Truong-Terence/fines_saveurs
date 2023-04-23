<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <title>Fines Saveurs | Catégories</title>
  <%@include file="../../styling/import-styles.jsp"%>
  <style>
    <%@include file="../../styling/global.css"%>
    <%@include file="style.css"%>
  </style>
</head>

<body id="categories" class="position-relative pb-5">

<c:import url="../header/" />

<div class="container pb-5">
  <div class="row flex-column justify-content-center">
    <div class="col d-flex flex-column justify-content-around">
      <h1 class="text-center my-5">Catégories</h1>
      <div class="square-grid my-3 py-5">
        <div class="square text-center d-flex justify-content-center align-items-center"><img src="../../images/plus-sign.svg" alt="ajouter une catégorie"></div>

        <jsp:useBean id="categories" scope="request" type="java.util.List"/>
        <c:forEach items="${categories}" var="category">
        <div class="square text-center d-flex justify-content-center align-items-center"><p>${category.name}</p></div>
        </c:forEach>

      </div>
    </div>
  </div>
</div>

<div class="container-fluid position-absolute bottom-0">
  <div class="row">
    <div class="col">
      <a href="products" class="underline-none">
        <button class="button d-block mx-auto my-5">Tous les produits</button>
      </a>
    </div>
  </div>
</div>

</body>

</html>
