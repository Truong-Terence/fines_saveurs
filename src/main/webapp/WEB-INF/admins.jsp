<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Admins</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/admins.css"%>
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
                <th scope="col">Rôle</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="admins" scope="request" type="java.util.List"/>
            <jsp:useBean id="emptyAdmins" scope="request" type="java.util.List"/>
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
                                Super Admin
                            </c:when>
                            <c:otherwise>
                                Admin
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/secured/edit-admin?id=${admin.id}"><button class="button" type="submit">Editer</button></a></td>
                    </td>
                    <td>
                        <c:if test="${fn: contains(emptyAdmins, admin)}">
                            <a href="${pageContext.request.contextPath}/secured/delete-admin?id=${admin.id}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                    <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
                                </svg>
                            </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
</body>
</html>