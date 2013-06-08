<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>
        <c:choose>
            <c:when test="${unitOfMeasure.id != null}">Masseinheit editieren</c:when>
            <c:otherwise>Neue Masseinheit</c:otherwise>
        </c:choose>
    </title>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/static/bootstrap/css/bootstrap.css" />"/>
</head>
<body>

<h3>
    <c:choose>
        <c:when test="${unitOfMeasure.id != null}">Masseinheit editieren</c:when>
        <c:otherwise>Masseinheit Zutat</c:otherwise>
    </c:choose>
</h3>

<form:form action="/uom/save" method="put" commandName="unitOfMeasure" id="unitOfMeasure_form" cssClass="noprint">
    <form:hidden path="id"/>

    <div class="row">
        <div class="span4">
            <fieldset>
                <div class="control-group <form:errors path="key">error</form:errors> ">
                    <form:label path="key" cssClass="control-label">Key</form:label>
                    <form:input path="key" cssClass="input-xlarge"/>
                    <div class="help-block"><form:errors path="key"/></div>
                </div>
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
            </fieldset>
        </div>
    </div>

    <div class="form-actions">

        <a href="/uom/" class="btn">Abbrechen</a>

        <button type="submit" class="btn btn-primary pull-right" id="submit">Speichern &nbsp
            <i class="icon-plus icon-white"></i>
        </button>


    </div>
</form:form>

</body>
</html>