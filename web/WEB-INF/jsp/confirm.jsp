<%@include file="top.jsp" %>
<div id="black-tl">
  <div id="black-tr">
    <div id="black-br">
      <div id="black-bl">
        <div class="black-box">
            <p>Validate your order:</p><br />
            <form action="confirm" method="post">
                Enter your details: <br />
                <textarea name="userdata" placeholder="name,last name,adress and phone number"></textarea><br />
                <input type="submit" value="Validate" />
            </form>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</div>
<%@include file="bottom.jsp" %>
