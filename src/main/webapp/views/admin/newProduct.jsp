<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 19/12/2023
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/userStyle.css" rel="stylesheet"/>
    <title>New Product</title>
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
        <form action="<%=request.getContextPath()%>/productController/create" method="post">
            <label for="id">Product Id</label>
            <input type="text" id="id" name="id"/><br>
            <label for="name">Product Name</label>
            <input type="text" id="name" name="name"/><br>
            <label for="price">Price</label>
            <input type="number" id="price" name="price"/><br>
            <label for="title">Title</label>
            <input type="text" id="title" name="title"/><br>
            <label for="catalog_id">Catalog</label>
            <select id="catalog_id" name="catalog.id">
                <c:forEach items="${listCategories}" var="catalog">
                    <option value="${catalog.id}">${catalog.name}</option>
                </c:forEach>
            </select><br>
            <label for="active">Status</label>
            <input type="radio" name="status" value="true" checked id="active"><label for="active">Active</label>
            <input type="radio" name="status" value="false" id="inactive"><label for="inactive">Inactive</label><br>
            <input type="submit" value="Create"/>
        </form>
    </div>
</div>
</body>
</html>
