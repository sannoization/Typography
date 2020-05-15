<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>OrderList</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<h2>Current Order Data</h2>
<br>
<a class="back" href="/orderlist">←</a>
<div class="margin"></div>
<table class="tg">
    <tr>
        <th width="80">Number of order</th>
        <th width="120">Customer passport</th>
    </tr>
    <tr>
        <td>${orderList.numoforder}</td>
        <td>${orderList.customer}</td>
    </tr>
</table>
</body>
</html>
