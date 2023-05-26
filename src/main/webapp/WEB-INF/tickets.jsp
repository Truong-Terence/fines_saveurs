<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
        <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
    </style>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">
    <h1>Tickets</h1>
    <table class="table table-striped">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Email client</th>
            <th scope="col">Message</th>
            <th scope="col">Archiver</th>
        </tr>
        <c:forEach var="ticket" items="${tickets}">
            <tr>
                <c:if test="${actualAdminId == ticket.adminId}">
                    <td>${ticket.id}</td>
                    <td>${ticket.userEmail}</td>
                    <td>${ticket.textInput}</td>
                    <td><a href="${pageContext.request.contextPath}/secured/delete-ticket?id=${ticket.id}"><button class="button d-block" type="submit">Supprimer</button></a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
