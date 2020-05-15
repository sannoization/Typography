<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Purchase order data</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<h2>Order Data</h2>
<br>
<a class="back" href="/purchaseorder">←</a>
<div class="margin"></div>
<table class="tg">
    <tr>
        <th width="80">Number</th>
        <th width="120">Placement date</th>
        <th width="120">Exercise date</th>
        <th width="120">Price</th>
        <th width="120">Service</th>
        <th width="120">Employee passport</th>
    </tr>
    <tr>
        <td>${purchaseorder.number}</td>
        <td>${purchaseorder.placementdate}</td>
        <td>${purchaseorder.exercisedate}</td>
        <td>${purchaseorder.price}</td>
        <td>${purchaseorder.service}</td>
        <td>${purchaseorder.employee}</td>
    </tr>
</table>
</body>
</html>
