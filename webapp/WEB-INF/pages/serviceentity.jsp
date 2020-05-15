<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Service</title>
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
<c:url var="addAction" value="/serviceentity/add"/>
<div class="margin"></div>
<h2>Services</h2>
<form:form action="${addAction}" modelAttribute="serviceentity">
    <table>
        <tr>
            <td>
                <form:label path="partnumber">
                    <spring:message text="Part number of service"/>
                </form:label>
            </td>
            <td>
                <form:input path="partnumber"  size="12" />
            </td>
            <td><form:errors path="partnumber" cssClass="error"/></td>
            <td class="example">example: 1111</td>
        </tr>

        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
            <td><form:errors path="name" cssClass="error"/></td>
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
                <form:label path="amount">
                    <spring:message text="Amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount"/>
            </td>
            <td><form:errors path="amount" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="material">
                    <spring:message text="Material"/>
                </form:label>
            </td>
            <td>
                <form:input path="material"/>
            </td>
            <td><form:errors path="material" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="options">
                    <spring:message text="Options"/>
                </form:label>
            </td>
            <td>
                <form:input path="options"/>
            </td>
            <td><form:errors path="options" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty serviceentity.partnumber}">
                    <input type="submit"
                           value="<spring:message text="Edit Service"/>"/>
                </c:if>
                <c:if test="${empty serviceentity.partnumber}">
                    <input type="submit"
                           value="<spring:message text="Add New service"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</br>
</br>

<c:if test="${!empty listservice}">
    <table class="tg">
        <tr>
            <th width="120">Part number of service</th>
            <th width="120">Name</th>
            <th width="120">Price</th>
            <th width="120">Amount</th>
            <th width="120">Material</th>
            <th width="120">Options</th>
            <th width="120">Edit</th>
            <th width="120">Delete</th>
        </tr>
        <c:forEach items="${listservice}" var="serviceentity">
            <tr>
                <td>${serviceentity.partnumber}</td>
                <td><a href="/servicedata/${serviceentity.partnumber}">${serviceentity.name}</a></td>
                <td>${serviceentity.price}</td>
                <td>${serviceentity.amount}</td>
                <td>${serviceentity.material}</td>
                <td>${serviceentity.options}</td>
                <td><a href="<c:url value='/editserviceentity/${serviceentity.partnumber}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeserviceentity/${serviceentity.partnumber}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
