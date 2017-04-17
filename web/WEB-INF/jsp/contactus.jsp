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
      <li><a href="cart">Cart</a></li>
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
  <h2>CONTACT</h2>
  <p>IF YOU HAVE ANY QUESTIONS, PLEASE CONTACT US.</p>
  <p class="more"><a href="http://all-free-download.com/free-website-templates/">&nbsp;</a></p>
</div>
<div id="black-tl">
  <div id="black-tr">
    <div id="black-br">
      <div id="black-bl">
        <div class="black-box">
          <h2>COMPANY HEADQUARTERS</h2>
          <p>Milovana Rajinca 10,</p>
          <p>34000 KRAGUJEVAC,</p>
          <p>SRBIJA.</p>
        </div>
        <div class="black-box">
          <h2>CONTACT INFO</h2>
          <p><a href="https://www.it-akademija.com">womenfashion@gmail.com</a></p>
          <p>+381 (0)65 22 64 496</p>
          <p class="more"> <a href="http://all-free-download.com/free-website-templates/">&nbsp;</a></p>
        </div>
        <div class="black-box">
            <h2>IDENTIFICATION NUMBER &amp; PIB</h2>
          <p>ID: 20550788</p>
          <p>PIB: 106185705</p>
          <p class="more"> <a href="http://all-free-download.com/free-website-templates/">&nbsp;</a></p>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</div>
<%@include file="bottom.jsp" %>

