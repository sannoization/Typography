<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>EmployeeData</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<h2>Employee Data</h2>
<br>
<a class="back" href="/employees">←</a>
<div class="margin"></div>
<table class="tg">
    <tr>
        <th width="120">Passport</th>
        <th width="120">First Name</th>
        <th width="120">Patronymic</th>
        <th width="120">Last Name</th>
        <th width="120">Phone</th>
    </tr>
    <tr>
        <td>${employee.passport}</td>
        <td>${employee.nameemployee}</td>
        <td>${employee.patronymicemployee}</td>
        <td>${employee.lastnameemployee}</td>
        <td>${employee.phone}</td>
    </tr>
</table>
</body>
</html>
