<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="footer"><c:forEach begin="1" end="${allpages}" varStatus="counter">
        <a href="?page=${counter.count}"><b>${counter.count}</b></a>
                </c:forEach></div>
<div class="clear"></div>
<div id="copyright"> Copyright Women Fashion Shop d.o.o. All rights reserved</div>
</body>
</html>