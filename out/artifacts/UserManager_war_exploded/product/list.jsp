<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 26/05/2020
  Time: 02:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Product Manager</title>
</head>
<body>
<center>
    <h1>Product Manager</h1>
    <h2>
        <a href="/products?action=create">Add New Product</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Product List</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Describe</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value = "${product.getProductId()}" /></td>
                <td><c:out value = "${product.getName()}" /></td>
                <td><c:out value = "${product.getPrice()}" /></td>
                <td><c:out value = "${product.getQuantity()}" /></td>
                <td><c:out value = "${product.getColor()}" /></td>
                <td><c:out value = "${product.getDescr()}" /></td>
                <td><c:out value = "${product.getCateId()}" /></td>
                <td>
                    <a href="/product?action=edit&id=${product.getProductId()}">Edit</a>
                    <a href="/product?action=delete&id=${product.getProductId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
