<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Fines Saveurs | Produits</title>
  <%@include file="../styling/import-styles.jsp"%>
  <style>
    <%@include file="../styling/global.css"%>
    <%@include file="../styling/products.css"%>
  </style>
</head>

<body id="products" class="pb-5">

  <c:import url="header.jsp"/>


  <form action="add-product" method="post" enctype="multipart/form-data">

    <div class="mb-3">
      <label for="file-selector" class="form-label">Choisir une image</label>
      <input class="form-control" type="file" id="file-selector" accept="image/jpg, image/jpeg" name="file">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>

  </form>

</body>

</html>