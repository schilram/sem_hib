<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/static/bootstrap/css/bootstrap.css" />"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/static/bootstrap/css/bootstrap-responsive.min.css" />"/>


    <title>Rezepte</title>
</head>
<body>

<jsp:include page="../_layout/menu.jsp"/>

<h3>Resultate</h3>

<c:if test="${list3hit.size() > 0}">
    <h4>Resultate mit 3 Treffern</h4>

    <div class="row">
        <div class="span12">
            <table class="table table-striped">
                <colgroup>
                    <col width="150">
                    <col width="550">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Beschreibung</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list3hit}" var="i">
                    <tr>
                        <td><c:out value="${i.name}" /></td>
                        <td><c:out value="${i.description}" /></td></a>
                        <td>
                            <a href="<c:url value="/recipes/${i.id}"/>"><i class="icon-zoom-in">&nbsp;</i></a>&nbsp;&nbsp;
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</c:if>
<c:if test="${list2hit.size() > 0}">
    <h4>Resultate mit 2 Treffern</h4>

    <div class="row">
        <div class="span12">
            <table class="table table-striped">
                <colgroup>
                    <col width="150">
                    <col width="550">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Beschreibung</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list2hit}" var="i">
                    <tr>
                        <td><c:out value="${i.name}" /></td>
                        <td><c:out value="${i.description}" /></td></a>
                        <td>
                            <a href="<c:url value="/recipes/${i.id}"/>"><i class="icon-zoom-in">&nbsp;</i></a>&nbsp;&nbsp;
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</c:if>

<c:if test="${list1hit.size() > 0}">
    <h4>Resultate mit 1 Treffer</h4>

    <div class="row">
        <div class="span12">
            <table class="table table-striped">
                <colgroup>
                    <col width="150">
                    <col width="550">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Beschreibung</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list1hit}" var="i">
                    <tr>
                        <td><c:out value="${i.name}" /></td>
                        <td><c:out value="${i.description}" /></td></a>
                        <td>
                            <a href="<c:url value="/recipes/${i.id}"/>"><i class="icon-zoom-in">&nbsp;</i></a>&nbsp;&nbsp;
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</c:if>

<div class="form-actions">
    <a href="<c:url value="/recipes/"/>" class="btn">Alle Rezepte</a>
    <a href="<c:url value="/search/"/>" class="btn btn-primary pull-right">Neue Suche</a>
</div>


</body>
</html>