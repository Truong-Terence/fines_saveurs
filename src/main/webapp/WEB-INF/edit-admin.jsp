<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fines Saveurs | Edition d'admin</title>
    <%@include file="../styling/import-styles.jsp"%>
    <style>
        <%@include file="../styling/global.css"%>
        <%@include file="../styling/form.css"%>
    </style>
</head>

<body class="pb-5">

<c:import url="header.jsp"/>

<div class="container py-5">
    <div class="row">
        <div class="col">
            <h2 class="text-center">Edition de l'administrateur</h2>
        </div>
    </div>
</div>

<div class="container">

    <div class="row">

        <div class="col-6 mx-auto">

            <form action="${pageContext.request.contextPath}/secured/edit-admin?id=${admin.id}" method="post">

                <%-- firstname --%>
                <div class="mb-3">
                    <label for="firstname" class="form-label">Prénom</label>
                    <input type="text" class="form-control" id="firstname" name="firstname" placeholder="John / Jeanne" value="${admin.firstname}" required>
                </div>

                <%-- lastname --%>
                <div class="mb-3">
                    <label for="lastname" class="form-label">Nom</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Doe" value="${admin.lastname}" required>
                </div>

                <%-- email --%>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="j.doe@gmail.com" value="${admin.email}" required>
                </div>

                <%-- password --%>
                <div class="mb-3">
                    <label for="password" class="form-label">Mdp</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="secret" value="${admin.password}" required>
                </div>

                <%-- status --%>
                <div class="mb-3">
                    <label for="status" class="form-label">SuperAdmin</label>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="status" name="status" ${admin.status ? 'checked' : ''}>
                        <label class="form-check-label" for="status">Actif / Inactif</label>
                    </div>
                </div>



                <button type="submit" class="block-center d-block mt-5 button">Soumettre</button>

            </form>


        </div>

    </div>

</div>


</body>

</html>