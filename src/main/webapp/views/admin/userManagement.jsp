<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 14/12/2023
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserManagement</title>
  <link href="<%=request.getContextPath()%>/resources/css/userStyle.css" rel="stylesheet"/>
</head>
<body>
  <div class="container">
    <div class="left">
      <ul>
        <li><a href="<%=request.getContextPath()%>/userController/findAll">User Management</a> </li>
        <li><a href="<%=request.getContextPath()%>/categoriesController/findAll">Categories Management</a> </li>
        <li><a href="<%=request.getContextPath()%>/productController/findAll">Product Management</a></li>
      </ul>
    </div>
    <div class="content">
      <table border="1">
        <thead>
          <tr>
            <th>User ID</th>
            <th>UserName</th>
            <th>Password</th>
            <th>Email</th>
            <th>Created</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listUser}" var="user">
            <tr>
              <td>${user.userId}</td>
              <td>${user.userName}</td>
              <td>${user.password}</td>
              <td>${user.email}</td>
              <td><fmt:formatDate value="${user.created}" pattern="dd/MM/yyyy"/></td>
              <td>${user.status?"Active":"Inactive"}</td>
              <td></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

</body>
</html>
