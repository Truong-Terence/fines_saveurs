<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Fines Saveurs | Edition de catégorie</title>
  <%@include file="../styling/import-styles.jsp"%>
  <style>
    <%@include file="../styling/global.css"%>
    <%@include file="../styling/form.css"%>
  </style>
</head>

<body>

<c:import url="header.jsp"/>

<div class="container py-5">
  <div class="row">
    <div class="col">
      <h2 class="text-center">Choisir une image</h2>
    </div>
  </div>
</div>

<div class="container">

  <div class="row">

    <div class="col-6 mx-auto">

      <form action="${pageContext.request.contextPath}/secured/edit-image?id=${productId}" method="post" enctype="multipart/form-data">

        <div class="mb-3">
          <input class="form-control" type="file" id="file-selector" accept="image/jpg, image/jpeg" name="file">
        </div>

        <button type="submit" class="block-center d-block mt-5 button">Soumettre</button>

      </form>

    </div>

  </div>

</div>


</body>

</html>