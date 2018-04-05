<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <c:forEach items="${hallDTOList}" var="hall">
        <c:out value="${hall.name}" default="err"/><br/>
        <img src="${pageContext.servletContext.contextPath}/img/${hall.planUrl}.jpg" alt=""><br/>
        <br/>
    </c:forEach>
</center>

</body>
</html>