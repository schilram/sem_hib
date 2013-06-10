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


    <title>
        <c:choose>
            <c:when test="${recipe.id != null}">Rezept editieren</c:when>
            <c:otherwise>Neues Rezept</c:otherwise>
        </c:choose>
    </title>


</head>
<body>

<jsp:include page="../_layout/menu.jsp"/>

<h3>
    <c:choose>
        <c:when test="${recipe.id != null}">Rezept editieren</c:when>
        <c:otherwise>Neues Rezept</c:otherwise>
    </c:choose>
</h3>

<form:form action="/recipes/save" method="put" commandName="recipe" id="recipe_form" cssClass="noprint">

    <form:hidden path="id"/>

    <div class="row">
        <div class="span4">
            <div class="control-group <form:errors path="name">error</form:errors> ">
                <form:label path="name" cssClass="control-label">Name</form:label>
                <form:input path="name" cssClass="input-xlarge"/>
                <div class="help-block"><form:errors path="name"/></div>
            </div>
        </div>
        <div class="span8">
            <div class="control-group <form:errors path="description">error</form:errors>">
                <form:label path="description" class="control-label">Beschreibung</form:label>
                <form:textarea rows="3" path="description" cssClass="input-xlarge"/>
                <div class="help-block"><form:errors path="description"/></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="span12">
            <table class="table table-striped" id="ingredient_table">
                <colgroup>
                    <col width="50">
                    <col width="50">
                    <col width="150">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>Anzahl</th>
                    <th>Masseinheit</th>
                    <th>Zutat</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${recipe.ingredients}" var="i" varStatus="status">
                    <tr>

                        <%--<td>--%>
                            <%--<spring:bind path="recipe.ingredients[${status.index}].amount">--%>
                                <%--<input type="text" name="<%=status.getExpression()%>" value="<%=status.getValue()%>"/>--%>
                            <%--</spring:bind>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<spring:bind path="recipe.ingredients[${status.index}].uom">--%>
                                <%--<select name="<%=status.getExpression()%>">--%>
                                    <%--<c:forEach items="${uom}" var="u">--%>
                                        <%--<c:set var="selectMe" value=""/>--%>
                                        <%--<c:forEach items="${status.actualValue}" var="curValue">--%>
                                            <%--<c:if test="${curValue == u.id}">--%>
                                                <%--<c:set var="selectMe" value="selected"/>--%>
                                            <%--</c:if>--%>
                                        <%--</c:forEach>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                                <%--<input type="text" name="<%=status.getExpression()%>" value="<%=status.getValue()%>"/>--%>
                            <%--</spring:bind>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<spring:bind path="recipe.ingredients[${status.index}].ingredient">--%>
                                <%--<input type="text" name="<%=status.getExpression()%>" value="<%=status.getValue()%>"/>--%>
                            <%--</spring:bind>--%>
                        <%--</td>--%>


                        <%--<td><c:out value="${i.id}" /></td>--%>
                        <%--<td><c:out value="${i.amount}" /></td>--%>
                        <%--<td><c:out value="${i.uom}" /></td>--%>
                        <%--<td><c:out value="${i.ingredient}" /></td>--%>
                        <%--<td>--%>
                            <%--<a href="/recipes/delete/${i.id}"><i class="icon-trash">&nbsp;</i></a>&nbsp;&nbsp;--%>
                        <%--</td>--%>
                        <form:hidden path="ingredients[${status.index}].id"/>
                        <td><form:input path="ingredients[${status.index}].amount" value="${i.amount}" cssClass="input-mini"/></td>
                        <td><form:select path="ingredients[${status.index}].uom" cssClass="input-small" items="${uom}" itemValue="id" itemLabel="key"/></td>
                        <td><form:select path="ingredients[${status.index}].ingredient" cssClass="input-small" items="${ingredients}" itemValue="id" itemLabel="name"/></td>


                        <%--<td><input name="ingredients[${status.index}].amount" value="${i.amount}"></td>--%>
                        <%--<td><input name="ingredients[${status.index}].uom" value="${i.uom.id}"></td>--%>
                        <%--<td><input name="ingredients[${status.index}].ingredient" value="${i.ingredient.id}"></td>--%>
                        <td>
                            <a href="/recipes/delete/${i.id}"><i class="icon-trash">&nbsp;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button type="submit" class="btn" name="addRow" id="addRow">Zeile hinzufügen</button>
        </div>
    </div>

    <div class="row">
        <div class="span8">
            <div class="control-group <form:errors path="instructions">error</form:errors>">
                <form:label path="instructions" class="control-label">Zubereitung</form:label>
                <form:textarea rows="10" path="instructions" cssClass="input-block-level"/>
                <div class="help-block"><form:errors path="instructions"/></div>
            </div>
        </div>
    </div>

    <div class="form-actions">

        <a href="/recipes/" class="btn">Abbrechen</a>

        <button type="submit" class="btn btn-primary pull-right" id="submit">Speichern &nbsp
            <i class="icon-plus icon-white"></i>
        </button>

    </div>
</form:form>

<%--<script type="text/javascript">--%>
    <%--$(document).ready(function($)--%>
    <%--{--%>
        <%--$('#addRow').click(function()--%>
        <%--{--%>
            <%--addTableRow($('#ingredient_table'));--%>
            <%--return false;--%>
        <%--});--%>

        <%--function addTableRow(table)--%>
        <%--{--%>
            <%--var $tr = $('#ingredient_table').find("tbody tr:last").clone();--%>

            <%--// get the name attribute for the input and select fields--%>
            <%--$tr.find("input,select").attr("name", function()--%>
            <%--{--%>
                <%--// create a unique name for the new field by incrementing--%>
                <%--var n = this.id.match(/[\d]+/) + 1;--%>
                <%--this.id.replace(/[d]+/, n);--%>

                <%--// and reset values--%>
                <%--this.value--%>

                <%--// repeat for id attributes--%>
            <%--}).attr("id", function()--%>
                <%--{--%>
                    <%--var n = this.id.match(/[\d]+/) + 1;--%>
                    <%--this.id.replace(/[d]+/, n);--%>
                <%--});--%>

            <%--// append the new row to the table--%>
            <%--$('#ingredient_table').find("tbody tr:last").after($tr);--%>
        <%--};--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>