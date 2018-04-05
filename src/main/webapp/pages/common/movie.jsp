<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<img src="${pageContext.servletContext.contextPath}/img/${movieDTO.posterUrl}.jpg" alt="">
${movieDTO.trailerUrl}
    <div>
        <c:out value="${movieDTO.title}" default="err"/>
        <c:out value="${movieDTO.description}" default="err"/>
        <c:out value="${movieDTO.duration}" default="err"/><br/>
    </div>
    <c:forEach items="${sessionDTOList}" var="session">
            <a href="${pageContext.servletContext.contextPath}/pages/common/regCommon/byTicket.jsp?sessionId=${session.id}"> Hall: ${session.hall.name} || Time: ${session.deliveryTime} || Price: ${session.price}</a><br/>
    </c:forEach>
</center>

</body>
</html>