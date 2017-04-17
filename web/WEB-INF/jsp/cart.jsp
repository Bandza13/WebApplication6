<%@include file="top.jsp" %>
<div id="black-tl">
  <div id="black-tr">
    <div id="black-br">
      <div id="black-bl"><c:forEach items="${products}" var="product">     
        <div class="black-box">
          <h2><em>${product.brand}</em></h2>
          <p><img src="resources/images/${product.photo}" width="120" height="105" alt="Pic 1" /></p>
          <p><b>Price:</b> <b>$${product.price}</b></p>
          <p><b>Quantity: </b>${product.quantity}</p>
          <p><b>Size: </b>${product.size}</p>
          <form action="remove" method="post">
              <input type="hidden" name="id" value="${product.id}" />
              <input type="submit" value="Remove from cart" />
          </form>
        </div></c:forEach>
        <div class="clear"></div><a href="confirm"><b>Validate your order</b></a>
      </div>
    </div>
  </div>
</div>
<%@include file="bottom.jsp" %>
