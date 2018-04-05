<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title><br/>
</head>
<body style="background-image:url(${pageContext.servletContext.contextPath}/img/mainPhone.jpg)">
<center>
   <div style="font-size:92px; color:white; font-family:fantasy">KinoArea</div><br/>
    <br/>
    <img src="${pageContext.servletContext.contextPath}/img/main1.jpg" alt="">
    <img src="${pageContext.servletContext.contextPath}/img/main3.jpg" alt="">
    <img src="${pageContext.servletContext.contextPath}/img/main2.jpg" alt="">
    <img src="${pageContext.servletContext.contextPath}/img/main4.jpg" alt="">
    <img src="${pageContext.servletContext.contextPath}/img/main5.jpg" alt=""><br/>
    <br/>
</center>
    <form name="Hall" method="post" action="${pageContext.servletContext.contextPath}/hall">
        <input type="submit" value="План залов" />
    </form>
<form name="Coordinates" method="post" action="${pageContext.servletContext.contextPath}/pages/common/coordinates.jsp">
    <input type="submit" value="Координаты/Контакты" />
</form>
<center>
    <c:forEach items="${movieDTOList}" var="movie">
        <a href="${pageContext.servletContext.contextPath}/movie?id=${movie.id}"><img src="${pageContext.servletContext.contextPath}/img/${movie.posterUrl}.jpg" alt=""></a>

    </c:forEach>
</center>
</body>
</html>