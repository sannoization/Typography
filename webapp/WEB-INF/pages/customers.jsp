<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <style>
        <%@include file='../css/style.css' %>
    </style>
    <title>Customers</title>
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
<div class="margin"></div>
<c:url var="addAction" value="/customers/add"/>
<h2>Work with customers</h2>
<form:form action="${addAction}" modelAttribute="customer">
    <table>
        <tr>
            <td>
                <form:label path="passport">
                    <spring:message text="Passport"/>
                </form:label>
            </td>
            <td>
                <form:input path="passport"  size="10" />
            </td>
            <td><form:errors path="passport" cssClass="error"/></td>
            <td class="example">example: 9999666777</td>
        </tr>

        <tr>
            <td>
                <form:label path="namecustomer">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td><form:input path="namecustomer"/></td>
            <td><form:errors path="namecustomer" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="patronymiccustomer">
                    <spring:message text="Patromymic"/>
                </form:label>
            </td>
            <td>
                <form:input path="patronymiccustomer"/>
            </td>
            <td><form:errors path="patronymiccustomer" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="lastnamecustomer">
                    <spring:message text="Last Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastnamecustomer"/>
            </td>
            <td><form:errors path="lastnamecustomer" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="phone">
                    <spring:message text="Phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phone"/>
            </td>
            <td><form:errors path="phone" cssClass="error"/></td>
            <td class="example">example: 9996665522</td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty customer.passport}">
                    <input type="submit"
                           value="<spring:message text="Edit Customer"/>"/>
                </c:if>
                <c:if test="${empty customer.passport}">
                    <input type="submit"
                           value="<spring:message text="Add New customer"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<div class="margin"></div>
<c:if test="${!empty listCustomers}">
    <table class="tg">
        <tr>
            <th width="120">Passport</th>
            <th width="120">First Name</th>
            <th width="120">Last Name</th>
            <th width="120">Patronymic</th>
            <th width="120">Phone</th>
            <th width="120">Edit</th>
            <th width="120">Delete</th>
        </tr>
        <c:forEach items="${listCustomers}" var="customer">
            <tr>
                <td>${customer.passport}</td>
                <td><a href="/customerdata/${customer.passport}">${customer.namecustomer}</a></td>
                <td>${customer.lastnamecustomer}</td>
                <td>${customer.patronymiccustomer}</td>
                <td>${customer.phone}</td>
                <td><a href="<c:url value='/editcustomer/${customer.passport}'/>">Edit</a></td>
                <td><a href="<c:url value='/removecustomer/${customer.passport}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
