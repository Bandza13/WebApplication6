<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<base href="/WomenFashionShop/" />
<title>Women fashion shop</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" href="resources/style.css" type="text/css" charset="utf-8" />
</head>
<body>
<div id="header">
    <h1><em>Women</em><strong>FASHION SHOP</strong></h1>
</div>
<div id="left-person"></div>
<div id="uppers">
  
  <div id="nav-top">
    <ul>
      <li><a href="">Home page</a> |</li>
      <li><a href="contactus">Contact us</a> |</li>
      <li><a href="cart">Cart</a> </li>
    </ul>
  </div>
</div>
<div id="nav">
  <div>
        <ul>
            <c:forEach items="${types}" var="type">
                <li><a href="./${type.id}">${type.name}</a> &nbsp;&nbsp;&nbsp;</li> 
            </c:forEach>
        </ul>
  </div>
</div>
<div id="body">
  <h2><em>Welcome</em> to women fashion shop</h2>
  <p>Make online fashion shop for women is a real challenge and therefore we offer only the highest quality brand products. Perfect cud dresses,
     shoes and accessories of the best design are everyday part of our range.</p>
  <p>Designed smart, open people, good taste with a certain level of lifestyle. We hope you will find everything you need.</p>
</div>
