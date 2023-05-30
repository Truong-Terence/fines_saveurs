<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fines Saveurs | Tickets</title>
        <%@include file="../styling/import-styles.jsp"%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/tickets.css"%>
    </style>
</head>
<body id="tickets">
<c:import url="header.jsp"/>
<div class="container">
    <h1 class="mt-5">Tickets</h1>
    <table class="table table-striped">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Email client</th>
            <th scope="col">Message</th>
            <th scope="col">Résoudre</th>
        </tr>
        <c:forEach var="ticket" items="${tickets}">
            <tr>
                <c:if test="${actualAdminId == ticket.adminId}">
                    <td>${ticket.id}</td>
                    <td>${ticket.userEmail}</td>
                    <td>${ticket.textInput}</td>
                    <td><a href="${pageContext.request.contextPath}/secured/delete-ticket?id=${ticket.id}"><span class="material-symbols-outlined">task</span></a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
