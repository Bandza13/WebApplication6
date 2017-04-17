<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin console</title>
    </head>
    <body>
        <%@include file="menu.jsp" %><br />
        <table border="1">
            <tr><td>Id</td><td>Brand</td><td>Price</td><td>Photo</td><td></td><td></td></tr>
            <c:forEach items="${products}" var="product">
                <tr><td>${product.id}</td><td>${product.brand}</td><td>$${product.price}</td><td><img src="../resources/images/${product.photo}" width="80" height="70" /></td><td><a href="updatearticle?id=${product.id}">change</a></td><td><a href="deleteArticle?id=${product.id}">delete</a></td></tr>
            </c:forEach>
                <tr><td colspan="6">
                        <c:forEach begin="1" end="${allpages}" varStatus="counter">
                            <a href="articles?page=${counter.count}">${counter.count}</a>
                        </c:forEach>
                </td></tr>
        </table>
    </body>
</html>
