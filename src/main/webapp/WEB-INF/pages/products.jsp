<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>ProductData</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to Main Menu</a>

<<br/>
<br/>

<h1> Product List </h1>

<c:if test="${!empty listDesktop}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">formFactor</th>
            <th width="120">serialNumber</th>
            <th width="120">manufacturer</th>
            <th width="120">amount</th>
            <th width="120">price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDesktop}" var="desktop">
            <tr>
                <td>${desktop.id}</td>
                <td><a href="/productdata/${desktop.id}" target="_blank">${desktop.formFactor}</a></td>
                <td>${desktop.serialNumber}</td>
                <td>${desktop.manufacturer}</td>
                <td>${desktop.amount}</td>
                <td>${desktop.price/100}${desktop.price%100}</td>
                <td><a href="<c:url value='/edit/${desktop.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${desktop.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
