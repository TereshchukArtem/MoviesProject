<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <c:forEach items="${ticketDTOList}" var="ticket">
        <c:out value="${ticket.session.price} || ${ticket.row} || ${ticket.seat} || ${ticket.session.movie.title}" default="err"/>
    </c:forEach>
</center>

</body>
</html>