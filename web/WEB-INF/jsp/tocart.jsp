<%@include file="top.jsp" %>
<div id="black-tl">
  <div id="black-tr">
    <div id="black-br">
      <div id="black-bl">
        <div class="black-box">
          <h2><em>${product.brand}</em></h2>
          <p><img src="resources/images/${product.photo}" width="120" height="105" alt="Pic 1" /></p>
          <p><b>Price:</b> <b>$${product.price}</b> </p>
          <form action="addtocart" method="post">
              <input type="hidden" name="id" value="${product.id}" />
              Quantity:<input type="number" min="1" name="quantity" value="1" />
              Size:<input type="text" name="size" placeholder="S,M,L or 36 to 42" />
              <input type="submit" value="Add to cart" />
          </form>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</div>
<%@include file="bottom.jsp" %>
