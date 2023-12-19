<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 19/12/2023
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/userStyle.css" rel="stylesheet"/>
    <title>List Categories</title>
</head>
<body>
<div class="container">
    <div class="left">
        <ul>
            <li><a href="<%=request.getContextPath()%>/userController/findAll">User Management</a></li>
            <li><a href="<%=request.getContextPath()%>/categoriesController/findAll">Categories Management</a></li>
            <li><a href="<%=request.getContextPath()%>/productController/findAll">Product Management</a></li>
        </ul>
    </div>
    <div class="content">
        <table border="1">
            <thead>
            <tr>
                <th>Catalog Id</th>
                <th>Catalog Name</th>
                <th>Description</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCategories}" var="catalog">
                <tr>
                    <td>${catalog.id}</td>
                    <td>${catalog.name}</td>
                    <td>${catalog.descriptions}</td>
                    <td>${catalog.status?"Active":"Inactive"}</td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
