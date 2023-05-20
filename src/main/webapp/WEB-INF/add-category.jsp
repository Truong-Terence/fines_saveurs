<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Category</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/form.css"%>
    </style>
</head>
<body>
<c:import url="header.jsp"/>
<div id="add-category" class="pb-5">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <h2 class="text-center">Nouvelle catégorie</h2>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-6 mx-auto">
                <form action="${pageContext.request.contextPath}/secured/add-category" method="post">
                    <div class="mb-3 d-flex align-items-center">
                        <label for="name" class="form-label">Nom de la catégorie</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Libanais ..">
                    </div>
                    <button type="submit" class="block-center d-block mt-5 button">Soumettre</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
