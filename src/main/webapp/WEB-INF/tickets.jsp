<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tickets</h1>
<table>
    <tr>
        <th>Ticket ID</th>
        <th>User Email</th>
        <th>Text Input</th>
        <th>Admin</th>
    </tr>
    <c:forEach var="ticket" items="${tickets}">
        <tr>
            <td>${ticket.id}</td>
            <td>${ticket.userEmail}</td>
            <td>${ticket.textInput}</td>
            <td>${ticket.adminId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
