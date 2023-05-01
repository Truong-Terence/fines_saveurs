<%--
  Created by IntelliJ IDEA.
  User: tvnte
  Date: 25/04/2023
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Category</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/add-category" method="post">
    <label for="name">Nom de la catégorie :</label>
    <input type="text" name="name" id="name">
    <br>
    <button type="submit">Ajouter</button>
</form>

</body>
</html>
