<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>succesfull</h3>
    <form name="ok" method="post" action="${pageContext.servletContext.contextPath}/pages/admin/admin.jsp">
        <input type="submit" value="Ok" />
    </form>
</center>
</body>
</html>