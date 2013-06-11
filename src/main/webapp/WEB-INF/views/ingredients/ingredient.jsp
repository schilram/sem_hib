<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/static/bootstrap/css/bootstrap.css" />"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/static/bootstrap/css/bootstrap-responsive.min.css" />"/>


    <title>
        <c:choose>
            <c:when test="${ingredient.id != null}">Zutat editieren</c:when>
            <c:otherwise>Neue Zutat</c:otherwise>
        </c:choose>
    </title>


</head>
<body>

<jsp:include page="../_layout/menu.jsp"/>

<h3>
    <c:choose>
        <c:when test="${ingredient.id != null}">Zutat editieren</c:when>
        <c:otherwise>Neue Zutat</c:otherwise>
    </c:choose>
</h3>

<form:form action="/ingredients/save" method="put" commandName="ingredient" id="ingredient_form" cssClass="noprint">
    <form:hidden path="id"/>

    <div class="row">
        <div class="span4">
            <fieldset>
                <div class="control-group <form:errors path="name">error</form:errors> ">
                    <form:label path="name" cssClass="control-label">Name</form:label>
                    <form:input path="name" cssClass="input-xlarge"/>
                    <div class="help-block"><form:errors path="name"/></div>
                </div>
                <div class="control-group <form:errors path="description">error</form:errors>">
                    <form:label path="description" class="control-label">Beschreibung</form:label>
                    <form:textarea rows="3" path="description" cssClass="input-xlarge"/>
                    <div class="help-block"><form:errors path="description"/></div>
                </div>
                <div class="control-group <form:errors path="flavour">error</form:errors> ">
                    <form:label path="flavour" cssClass="control-label">Geschmack</form:label>
                    <form:select path="flavour" cssClass="input-xlarge">
                        <form:option label=" - bitte wählen -" value=""></form:option>
                        <form:options />
                    </form:select>
                    <div class="help-block"><form:errors path="flavour"/></div>
                </div>
            </fieldset>
        </div>
    </div>

    <div class="form-actions">

        <a href="<c:url value="/ingredients/"/>" class="btn">Abbrechen</a>

        <button type="submit" class="btn btn-primary pull-right" id="submit">Speichern &nbsp
            <i class="icon-plus icon-white"></i>
        </button>


    </div>
</form:form>

</body>
</html>