<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin console</title>
    </head>
    <%@include file="menu.jsp" %>
    <body>
        <br />
        Instructions for column "Product information" <br />
        <b>id</b>: Type of product<br /><b>q</b>: Quantity<br /><b>s</b>: Size<br />
        <form action="deleteOrder" method="post">
            <table border="1">
                <tr><td><b>Id</b></td><td><b>User data</b></td><td><b>Time ordering</b></td><td><b>Product information</b></td><td></td></tr>
                <c:forEach items="${orders}" var="order">
                    <tr><td>${order.id}</td><td>${order.userdata}</td><td>${order.ordertime}</td><td>${order.articles}</td><td><a href="deleteOrder?id=${order.id}">Delete</a></td></tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
