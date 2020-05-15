<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employees</title>
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
            <a href="/qcashemployees"><li>cash</li></a>
            <a href="/qjointable1"><li>jointable</li></a>
        </ul>
    </nav>
</header>
<div class="margin"></div>
<c:url var="addAction" value="/employees/add"/>
<h2>Work with Employees</h2>
<form:form action="${addAction}" modelAttribute="employee">
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
                <form:label path="nameemployee">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameemployee"/>
            </td>
            <td><form:errors path="nameemployee" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="patronymicemployee">
                    <spring:message text="Patronymic"/>
                </form:label>
            </td>
            <td>
                <form:input path="patronymicemployee"/>
            </td>
            <td><form:errors path="patronymicemployee" cssClass="error"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="lastnameemployee">
                    <spring:message text="Last name"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastnameemployee"/>
            </td>
            <td><form:errors path="lastnameemployee" cssClass="error"/></td>
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
            <td class="example">example: 8(999)666-55-22</td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty employee.passport}">
                    <input type="submit"
                           value="<spring:message text="Edit Employee"/>"/>
                </c:if>
                <c:if test="${empty employee.passport}">
                    <input type="submit"
                           value="<spring:message text="Add New Employee"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<br/>
<br/>

<c:if test="${!empty listEmployees}">
    <table class="tg">
        <tr>
            <th width="120">Passport</th>
            <th width="120">First Name</th>
            <th width="120">Patronymic</th>
            <th width="120">Last Name</th>
            <th width="120">Phone</th>
            <th width="120">Edit</th>
            <th width="120">Delete</th>
        </tr>
        <c:forEach items="${listEmployees}" var="employee">
            <tr>
                <td>${employee.passport}</td>
                <td><a href="/employeedata/${employee.passport}">${employee.nameemployee}</a></td>
                <td>${employee.patronymicemployee}</td>
                <td>${employee.lastnameemployee}</td>
                <td>${employee.phone}</td>
                <td><a href="<c:url value='/edit/${employee.passport}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${employee.passport}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>



</body>
</html>

