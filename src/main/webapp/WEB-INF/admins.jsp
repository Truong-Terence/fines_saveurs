<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Admins</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/products.css"%>
    </style>
</head>

<body id="admins">



<div class="container">
    <c:import url="header.jsp"/>


    <c:url value="/secured/add-admin" var="addAdmin" />
    <a href="${addAdmin}">Ajouter</a>



    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Prénom</th>
            <th scope="col">Nom</th>
            <th scope="col">Email</th>
            <th scope="col">Mdp</th>
            <th scope="col">SuperAdmin</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <th scope="row">${admin.id}</th>
                <td>${admin.firstname}</td>
                <td>${admin.lastname}</td>
                <td>${admin.email}</td>
                <td>${admin.password}</td>
                <td>
                    <c:choose>
                        <c:when test="${admin.status}">
                            Actif
                        </c:when>
                        <c:otherwise>
                            Inactif
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/secured/edit-admin?id=${admin.id}"><button class="button" type="submit">Editer</button></a></td>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/secured/delete-admin?id=${admin.id}"><button class="button" type="submit">Supprimer</button></a></td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

<%--<script>--%>
<%--    if (document.getElementsByClassName("product-card").length > 0) {--%>
<%--        document.getElementById("no-result").style.display = "none";--%>
<%--    }--%>

<%--    const handleClick = event => {--%>
<%--        const inputElement = event.target;--%>
<%--        inputElement.setSelectionRange(0, inputElement.value.length);--%>
<%--    }--%>

<%--    document--%>
<%--        .querySelector('input[name="keywords"]')--%>
<%--        .addEventListener("click", handleClick);--%>

<%--</script>--%>

</body>

</html>