<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin console</title>
    </head>
    <body>
        <%@include file="menu.jsp" %><br />
        <h4>Update type</h4>
        <form action="updatetype" method="post">
            <select onchange="if(this.value!=-1) window.location='./types?id='+this.value" name="id">
                <option value="-1">Select type:</option>
                <c:forEach items="${types}" var="type">
                    <option <c:if test="${type.id==selectedType.id}">selected</c:if> value="${type.id}">${type.name}</option>
                </c:forEach>
            </select><br />
            Name: <input type="text" name="name" value="${selectedType.name}" /><br />
            <input type="submit" name="update" value="Update type" />
        </form>
            <br />
            
            <h4>Delete type</h4>
            <form action="deleteType" method="post">   
            <table border="1">
                <tr><td>Id</td><td>Type</td><td></td></tr>
                <c:forEach items="${types}" var="type">
                    <tr><td>${type.id}</td><td>${type.name}</td><td><a href="deleteType?id=${type.id}">Delete</a></td></tr>
                </c:forEach>
            </table><br />
            </form><br />
            
            <h4>Add new type</h4>
            <form action="addNewType" method="post">
                Add new type of product: <input type="text" name="name" value="${type.name}" /><br />
                <input type="submit" value="Add type" />
            </form>
    </body>
</html>
