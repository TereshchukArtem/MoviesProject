<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <c:out value="${sessionScope.messageByRegister}"/>
    <form name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/register">
        Login: <input type="text" name="login"/> <br/>
        Password: <input type="password" name="password"/> <br/>
        FirstName: <input type="text" name="firstName"/> <br/>
        LastName: <input type="text" name="lastName"/> <br/>
        Email: <input type="email" name="email"/> <br/>
        Sex: <input type="text" name="sex"/> <br/>
        Birthday: <input type="date" name="birthday"/> <br/>
        <input type="submit" value="Enter" /><br/>
    </form>
</center>

</body>
</html>