<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>serviceData</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<h2>Service Data</h2>
<br>
<a class="back" href="/serviceentity">←</a>
<div class="margin"></div>
<table class="tg">
    <tr>
        <th width="80">Part number</th>
        <th width="120">Name</th>
        <th width="120">Price</th>
        <th width="120">Amount</th>
        <th width="120">Material</th>
        <th width="120">Options</th>
    </tr>
    <tr>
        <td>${serviceentity.partnumber}</td>
        <td>${serviceentity.name}</td>
        <td>${serviceentity.price}</td>
        <td>${serviceentity.amount}</td>
        <td>${serviceentity.material}</td>
        <td>${serviceentity.options}</td>
    </tr>
</table>
</body>
</html>
