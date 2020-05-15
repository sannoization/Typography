<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Purchase order</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>

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
<div class="margin"></div>
<h2>Work with Orders</h2>
<c:url var="addAction" value="/purchaseorder/add"/>

<form:form action="${addAction}" modelAttribute="purchaseorder">
    <table>
        <tr>
            <td>
                <form:label path="number">
                    <spring:message text="Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="number"  size="12" />
            </td>
            <td><form:errors path="number" cssClass="error"/></td>
        </tr>

        <tr>
            <td>
                <form:label path="placementdate">
                    <spring:message text="Placement date"/>
                </form:label>
            </td>
            <td>
                <form:input path="placementdate"/>
            </td>
            <td><form:errors path="placementdate" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="exercisedate">
                    <spring:message text="Exercise date"/>
                </form:label>
            </td>
            <td>
                <form:input path="exercisedate"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
            <td><form:errors path="price" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="service">
                    <spring:message text="Service number"/>
                </form:label>
            </td>
            <td>
                <form:input path="service"/>
            </td>
            <td><form:errors path="service" cssClass="error"/></td>
            <td class="example">example: 1111</td>
        </tr>
        <tr>
            <td>
                <form:label path="employee">
                    <spring:message text="Employee passport"/>
                </form:label>
            </td>
            <td>
                <form:input path="employee"/>
            </td>
            <td><form:errors path="employee" cssClass="error"/></td>
            <td class="example">example: 9999666777</td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty purchaseorder.number}">
                    <input type="submit"
                           value="<spring:message text="Edit order"/>"/>
                </c:if>
                <c:if test="${empty purchaseorder.number}">
                    <input type="submit"
                           value="<spring:message text="Add New order"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</br>
</br>

<c:if test="${!empty listpurchaseorder}">
    <table class="tg">
        <tr>
            <th width="120">Number</th>
            <th width="120">Placement date</th>
            <th width="120">Exercise date</th>
            <th width="120">Price</th>
            <th width="120">Service number</th>
            <th width="120">Employee passport</th>
            <th width="120">Edit</th>
            <th width="120">Delete</th>
        </tr>
        <c:forEach items="${listpurchaseorder}" var="purchaseorder">
            <tr>
                <td>${purchaseorder.number}</td>
                <td><a href="/purchaseorderdata/${purchaseorder.number}">${purchaseorder.placementdate}</a></td>
                <td>${purchaseorder.exercisedate}</td>
                <td>${purchaseorder.price}</td>
                <td>${purchaseorder.service}</td>
                <td>${purchaseorder.employee}</td>
                <td><a href="<c:url value='/editorder/${purchaseorder.number}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeorder/${purchaseorder.number}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
