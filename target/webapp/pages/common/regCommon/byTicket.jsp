<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <c:out value="${sessionScope.messageByTicket}"/>
    <form name="buyTicket" method="post" action="${pageContext.servletContext.contextPath}/buyTicket">
        row: <input type="number" name="row"/> <br/>
        seat: <input type="number" name="seat"/> <br/>
        <input type="hidden" name="sessionId" value="${param.sessionId}"/> <br/>
        <input type="submit" value="buy" /><br/>
    </form>
</center>
<form name="myTickets" method="post" action="${pageContext.servletContext.contextPath}/myTickets">
    <input type="submit" value="Мои билеты" />
</form>
</body>
</html>