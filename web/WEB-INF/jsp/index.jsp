<%@include file="top.jsp" %>
<div id="black-tl">
  <div id="black-tr">
    <div id="black-br">
      <div id="black-bl">
          <c:forEach items="${products}" var="product">
        <div class="black-box">
          <h2><em>${product.brand}</em></h2>
          <p><img src="resources/images/${product.photo}" width="120" height="105" alt="Pic 1" /></p>
          <p><b>Price:</b> <b>$${product.price}</b> </p>
          <p class="more"><a href="tocart/${product.id}"><b>Buy</b></a></p>
        </div>
        </c:forEach>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</div>
<%@include file="bottom.jsp" %>
