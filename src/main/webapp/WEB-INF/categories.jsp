<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html lang="fr">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Fines Saveurs | Catégories</title>
  <%@include file="../styling/import-styles.jsp"%>
  <style>
    <%@include file="../styling/global.css"%>
    <%@include file="../styling/categories.css"%>
  </style>
</head>

<body id="categories" class="position-relative">

  <c:import url="header.jsp" />

  <div class="page">


    <div class="container pb-5">
      <div class="row flex-column justify-content-center">
        <div class="col d-flex flex-column justify-content-around">
          <h2 class="text-center my-5">Catégories</h2>
            <div class="square-grid my-3 py-5">
              <a href="${pageContext.request.contextPath}/secured/add-category" class="ms-auto"><div class="square text-center d-flex justify-content-center align-items-center"><img src="../images/plus-sign.svg" alt="ajouter une catégorie"></div></a>
                <jsp:useBean id="categories" scope="request" type="java.util.List"/>
                <jsp:useBean id="emptyCategories" scope="request" type="java.util.List"/>
                <c:forEach items="${categories}" var="category">

                <div class="square text-center d-flex justify-content-center align-items-center">
                  <p>
                      <a class="stretched-link" href="${pageContext.request.contextPath}/secured/products?category_id=${category.id}&category_name=${category.name}">
                        ${category.name}
                      </a>
                  </p>
                  <a href="${pageContext.request.contextPath}/secured/edit-category?id=${category.id}">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                      <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                      <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                    </svg>
                  </a>

                  <c:if test="${fn: contains(emptyCategories, category)}">
                    <a href="${pageContext.request.contextPath}/secured/delete-category?id=${category.id}">
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                        <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
                      </svg>
                    </a>
                  </c:if>
                </div>
                </c:forEach>
            </div>
        </div>
      </div>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col">
          <a href="${pageContext.request.contextPath}/secured/products" class="underline-none">
            <button class="button d-block mx-auto my-5">Tous les produits</button>
          </a>
        </div>
      </div>
    </div>

  </div>

  </body>

</html>
