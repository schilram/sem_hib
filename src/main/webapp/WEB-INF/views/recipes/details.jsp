<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/static/bootstrap/css/bootstrap.css" />"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/static/bootstrap/css/bootstrap-responsive.min.css" />"/>


    <title>Rezept Details</title>


</head>
<body>

<jsp:include page="../_layout/menu.jsp"/>

<h3>${recipe.name}</h3>

<p>${recipe.description}</p>

<h4>Zutaten</h4>

<div class="row">
    <div class="span8">
        <table class="table table-striped" id="ingredient_table">
            <colgroup>
                <col width="10">
                <col width="20">
                <col width="600">
            </colgroup>
            <thead>
            <tr>
                <th>Anzahl</th>
                <th>Masseinheit</th>
                <th>Zutat</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${recipe.ingredients}" var="i" varStatus="status">
                <tr>
                    <td>${i.amount}</td>
                    <td>${i.uom.key}</td>
                    <td>${i.ingredient.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<h4>Zubereitung</h4>
<textarea rows="20" style="width: 750px">${recipe.instructions}</textarea>

    <div class="form-actions">
        <a href="/recipes/" class="btn">Zu allen Rezepten</a>
    </div>

</body>
</html>