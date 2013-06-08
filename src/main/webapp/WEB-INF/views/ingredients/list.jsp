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


    <title>Zutaten</title>
</head>
<body>

<jsp:include page="../_layout/menu.jsp"/>

<h3>Zutaten</h3>
<div class="row">
    <div class="span12">
        <table class="table table-striped">
            <colgroup>
                <col width="50">
                <col width="150">
                <col width="450">
                <col width="100">
                <col width="100">
            </colgroup>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Beschreibung</th>
                <th>Geschmack</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ingredients}" var="i">
                <tr>
                    <td><c:out value="${i.id}" /></td>
                    <td><c:out value="${i.name}" /></td>
                    <td><c:out value="${i.description}" /></td>
                    <td><c:out value="${i.flavour}" /></td>
                    <td>
                        <a href="/ingredients/edit/${i.id}"><i class="icon-pencil">&nbsp;</i></a>&nbsp;&nbsp;
                        <a href="/ingredients/delete/${i.id}"><i class="icon-trash">&nbsp;</i></a>&nbsp;&nbsp;
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<div class="form-actions">
    <a href="/ingredients/add" class="btn btn-primary">Zutat Hinzufügen <i class="icon-plus icon-white"></i></a>
</div>


</body>
</html>