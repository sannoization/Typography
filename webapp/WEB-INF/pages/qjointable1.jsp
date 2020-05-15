<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Join table</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<br>
<c:url var="addAction" value="/qjointable1"/>
<a class="back" href="/employees">←</a>
<div class="margin"></div>
<h2>Join Table</h2>
<c:if test="${empty JoinTable1}">
<table class="tg">
    <thead>
    <tr>
        <th width="80">Order number</th>
        <th width="120">Customer name</th>
        <th width="120">Customer last name</th>
        <th width="120">Service name</th>
        <th width="120">Price</th>
    </tr>
    </thead>
    <c:forEach items="${JoinTable1}" var="jointable">
        <tbody>
        <tr>
            <td colspan="5" align="center">${jointable}</td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</c:if>
</body>
</html>
