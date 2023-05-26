<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<style><%@include file="../styling/header.css"%></style>


    <div class="container-fluid fixed-top bg-beige">
        <div class="row">
            <div class="col">

                <div class="container">
                    <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top margins">
                        <div class="container-fluid">

                            <c:choose>
                                <c:when test="${empty sessionScope.email}">
                                    <a class="navbar-brand" href="">
                                        <img src="/images/logo-transparent.svg" alt="logo" class="logo">
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="navbar-brand" href="${pageContext.request.contextPath}/secured/categories">
                                        <img src="/images/logo-transparent.svg" alt="logo" class="logo">
                                    </a>
                                </c:otherwise>
                            </c:choose>

                            <c:if test="${not empty sessionScope.email}">
                                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                                        <li class="nav-item ms-3" id="categories-li">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/secured/categories">Cat&eacute;gories</a>
                                        </li>
                                        <li class="nav-item ms-3" id="products-li">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/secured/products">Produits</a>
                                        </li>
                                        <li class="nav-item ms-3" id="ticket-li">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/secured/tickets">Tickets</a>
                                        </li>
                                        <li class="nav-item ms-3" id="logout-li">
                                            <a href="${pageContext.request.contextPath}/logout" class="underline-none">
                                                <button class="button-outline d-block ms-5 my-0">Se d&eacute;connecter</button>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                    </nav>
                </div>

            </div>
        </div>
    </div>

</body>