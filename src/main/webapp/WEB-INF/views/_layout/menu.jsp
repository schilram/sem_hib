<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="navbar">
    <div class="navbar-inner">
        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <a class="brand" href="/recipes/">Rezepte</a>

            <div class="nav-collapse">
                <ul id="navigation" class="nav">

                    <li class="divider-vertical"></li>

                    <%-- Rezepte --%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Rezepte
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value="/recipes/"/>">Alle Rezepte</a></li>
                            <li><a href="<c:url value="/recipes/add"/>">Neues Rezept erfassen</a></li>

                        </ul>
                    </li>
                    <li class="divider-vertical"></li>

                    <%-- Zutaten --%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Zutaten
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value="/ingredients/"/>">Alle Zutaten</a></li>
                            <li><a href="<c:url value="/ingredients/add"/>">Neue Zutat erfassen</a></li>

                        </ul>
                    </li>
                    <li class="divider-vertical"></li>


                    <%-- Masseinheiten --%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Masseinheiten
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value="/uom/"/>">Alle Masseinheiten</a></li>
                            <li><a href="<c:url value="/uom/add"/>">Neue Masseinheit erfassen</a></li>
                        </ul>
                    </li>
                    <li class="divider-vertical"></li>

                    <%-- Suche --%>
                    <li><a href="<c:url value="/search/"/>">Suche</a></li>
                    <li class="divider-vertical"></li>

                </ul>

            </div>
        </div>
    </div>
</div>
