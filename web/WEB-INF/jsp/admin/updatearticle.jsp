<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin console</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h4>Update article</h4>
        <form action="updatearticle" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${product.id}" /><br />
            Brand: <input type="text" name="brand" value="${product.brand}"><br />
            Price: <input type="text" name="price" value="${product.price}"><br />
            Type product: <select name="type" />
                <c:forEach items="${types}" var="type">
                    <option <c:if test="${type.id==product.type}">selected</c:if> value="${type.id}">${type.name}</option>
                </c:forEach>
            </select><br /><br />
            Insert photo: <input type="file" name="photo" /><br />
            <input type="submit" name="update" value="Update article" />
        </form><br />
         
        <h4>Add new article</h4>
        <form action="addNewArticle" method="post" enctype="multipart/form-data">
            Brand: <input type="text" name="brand" value="${product.brand}" /><br />
            Price: <input type="text" name="price" value="${product.price}"/><br />
            Type product: <input type="text" name="type" value="${product.type}" /><br />
            Insert picture: <input type="file" name="photo" /><br />
            <input type="submit" value="Add article" />
        </form>
    </body>
</html>
