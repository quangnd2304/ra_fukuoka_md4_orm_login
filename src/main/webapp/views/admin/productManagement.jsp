<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 19/12/2023
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/userStyle.css" rel="stylesheet"/>
    <title>List Product</title>
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
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Created</th>
                <th>Title</th>
                <th>Catalog Name</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${listProduct}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td><fmt:formatDate value="${product.created}" pattern="dd/MM/yyyy"/></td>
                        <td>${product.title}</td>
                        <td>${product.catalog.name}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create New Product</a>
</html>
