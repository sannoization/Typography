<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Cash Employees</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<br>
<c:url var="addAction" value="/qcashemployees"/>
<a class="back" href="/employees">←</a>
<div class="margin"></div>
<h2>Employee cash</h2>
<c:if test="${empty CashEmployees}">
<table class="tg">
    <thead>
        <tr>
            <th width="80">Name</th>
            <th width="120">Last Name</th>
            <th width="120">Cash sum</th>
        </tr>
    </thead>
    <c:forEach items="${CashEmployees}" var="CashEmployees">
    <tbody>
        <tr>
            <td colspan="3">${СashEmployees}</td>
        </tr>
    </tbody>
    </c:forEach>
</table>
</c:if>
</body>
</html>
