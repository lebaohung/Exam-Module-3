<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 26/05/2020
  Time: 02:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>

</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
<%--        <a href="product/list.jsp">List All Orders</a>--%>
    </h2>
</center>
<div >
    <form method="post">
        <p>
            <c:if test="${message != null}">
                <span ><c:out value="${message}"/></span>
            </c:if>
        </p>
        <table >
            <tr >
                <td colspan="7"> Edit product </td>
            </tr>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.productId}' />"/>
            </c:if>
            <tr>
                <th>Product ID: </th>
                <td>
                    <input type="text" name="productId" size="45"
                           value="<c:out value='${product.productId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product name: </th>
                <td>
                    <input type="text" name="productName" size="45"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="date" size="15"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity: </th>
                <td>
                    <input type="text" name="time" size="45"
                           value="<c:out value='${product.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Color </th>
                <td>
                    <input type="text" name="guestNum" size="45"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description </th>
                <td>
                    <input type="text" name="guestNum" size="45"
                           value="<c:out value='${product.descr}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Catelogy </th>
                <td>
                    <input type="text" name="guestNum" size="45"
                           value="<c:out value='${product.cateId}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" >Save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

