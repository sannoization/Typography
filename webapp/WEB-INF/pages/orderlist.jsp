<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>orderlist</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<header>
    <nav class="menu">
        <ul>
            <a href="/employees"><li>Employees</li></a>
            <a href="/customers"><li>Customers</li></a>
            <a href="/serviceentity"><li>Service</li></a>
            <a href="/orderlist"><li>List of orders</li></a>
            <a href="/purchaseorder"><li>Orders</li></a>
        </ul>
    </nav>
</header>
<c:url var="addAction" value="/orderlist/add"/>
<div class="margin"></div>
<h2>List of orders</h2>
<form:form action="${addAction}" modelAttribute="orderList">
    <table>
        <tr>
            <td>
                <form:label path="numoforder">
                    <spring:message text="Number of order"/>
                </form:label>
            </td>
            <td>
                <form:input path="numoforder"  size="10" />
            </td>
            <td><form:errors path="numoforder" cssClass="error"/></td>
        </tr>

        <tr>
            <td>
                <form:label path="customer">
                    <spring:message text="Customer passport"/>
                </form:label>
            </td>
            <td>
                <form:input path="customer"/>
            </td>
            <td><form:errors path="customer" cssClass="error"/></td>
            <td class="example">example: 9999666777</td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty orderList.numoforder}">
                    <input type="submit"
                           value="<spring:message text="Edit Orderlist"/>"/>
                </c:if>
                <c:if test="${empty orderList.numoforder}">
                    <input type="submit"
                           value="<spring:message text="Add New Orderlist"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</br>
</br>

<c:if test="${!empty listOrderLists}">
    <table class="tg">
        <tr>
            <th width="120">Number of order</th>
            <th width="120">Customer passport</th>
            <th width="120">Edit</th>
            <th width="120">Delete</th>
        </tr>
        <c:forEach items="${listOrderLists}" var="orderList">
            <tr>
                <td>${orderList.numoforder}</td>
                <td><a href="/orderlistdata/${orderList.numoforder}">${orderList.customer}</a></td>
                <td><a href="<c:url value='/editorderlist/${orderList.numoforder}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeorderlist/${orderList.numoforder}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
