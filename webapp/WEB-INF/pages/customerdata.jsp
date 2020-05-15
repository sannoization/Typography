<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <style>
        <%@include file='../css/style.css' %>
    </style>

    <title>Customers</title>
</head>
<body>
<br>
<a class="back" href="/customers">←</a>
<div class="margin"></div>
<h2>Customer Data</h2>
<table class="tg">
    <tr>
        <th width="120">Passport</th>
        <th width="120">First Name</th>
        <th width="120">Patronymic</th>
        <th width="120">Last Name</th>
        <th width="120">Phone</th>
    </tr>
    <tr>
        <td>${customer.passport}</td>
        <td>${customer.namecustomer}</td>
        <td>${customer.patronymiccustomer}</td>
        <td>${customer.lastnamecustomer}</td>
        <td>${customer.phone}</td>
    </tr>
</table>
</body>
</html>
