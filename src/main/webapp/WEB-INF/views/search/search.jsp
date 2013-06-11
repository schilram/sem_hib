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


    <title>Suche</title>

</head>
<body>

<jsp:include page="../_layout/menu.jsp"/>

<h3>Suche nach Rezepten mit Zutaten:</h3>

<form:form action="/search/result" method="post" commandName="searchForm" id="search_form" cssClass="noprint">
    <div class="row">
        <div class="span4">
            <div class="control-group <form:errors path="ingredient1">error</form:errors> ">
                <form:label path="ingredient1" cssClass="control-label">Zutat 1</form:label>
                <form:select path="ingredient1" cssClass="input-xlarge">
                    <form:option value="" label="-- auswählen --"/>
                    <form:options items="${ingredients}" itemValue="id" itemLabel="name"/>
                </form:select>
                <div class="help-block"><form:errors path="ingredient1"/></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="span4">
            <div class="control-group <form:errors path="ingredient2">error</form:errors> ">
                <form:label path="ingredient2" cssClass="control-label">Zutat 2</form:label>
                <form:select path="ingredient2" cssClass="input-xlarge">
                    <form:option value="" label="-- auswählen --"/>
                    <form:options items="${ingredients}" itemValue="id" itemLabel="name"/>
                </form:select>
                <div class="help-block"><form:errors path="ingredient2"/></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="span4">
            <div class="control-group <form:errors path="ingredient3">error</form:errors> ">
                <form:label path="ingredient3" cssClass="control-label">Zutat 3</form:label>
                <form:select path="ingredient3" cssClass="input-xlarge">
                    <form:option value="" label="-- auswählen --"/>
                    <form:options items="${ingredients}" itemValue="id" itemLabel="name"/>
                </form:select>
                <div class="help-block"><form:errors path="ingredient3"/></div>
            </div>
        </div>
    </div>


    <div class="form-actions">

        <a href="<c:url value="/recipes/"/>" class="btn">Zurück zur Liste</a>

        <button type="submit" class="btn btn-primary pull-right" id="submit">Suchen</button>

    </div>
</form:form>

</body>
</html>