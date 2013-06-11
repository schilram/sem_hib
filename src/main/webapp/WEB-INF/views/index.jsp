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


    <title>Rezept Verwalung</title>


</head>
<body>

<jsp:include page="_layout/menu.jsp"/>

<h3>Rezept Verwalung</h3>
<table>
    <colgroup>
        <col width="150">
        <col width="150">
    </colgroup>
    <tr>
        <td> 1. Zutaten erfassen</td>
        <td><a href="/ingredients/">Zu den Zutaten</a></td>
    </tr>
    <tr>
        <td> 2. Masseinheiten erfassen</td>
        <td><a href="/uom/">Zu den Masseinheiten</a></td>
    </tr>
    <tr>
        <td> 2. Rezepte erfassen</td>
        <td><a href="/recipes/">Zu den Rezepten</a></td>
    </tr>
    <tr>
        <td> 3. Rezepte suchen</td>
        <td><a href="/search/">Zur Suche</a></td>
    </tr>
</table>


</body>
</html>