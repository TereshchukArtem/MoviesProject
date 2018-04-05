<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <h3>Добавить фильм</h3>
<form name="movieAdd" method="post" action="${pageContext.servletContext.contextPath}/adminAdd">
    title: <input type="text" name="title"/> <br/>
    genre: <input type="text" name="genre"/> <br/>
    description: <input type="text" name="description"/> <br/>
    duration: <input type="number" name="duration"/> <br/>
    startRelease: <input type="date" name="startRelease"/> <br/>
    finishRelease: <input type="date" name="finishRelease"/> <br/>
    posterUrl: <input type="text" name="posterUrl"/> <br/>
    trailerUrl: <input type="text" name="trailerUrl"/> <br/>
                <input type="submit" value="Add" /><br/>
    <br/>
</form>
        <h3>Обновить фильм</h3>
<form name="movieUpdate" method="post" action="${pageContext.servletContext.contextPath}/adminUpdate">
    title: <input type="text" name="title"/> <br/>
    genre: <input type="text" name="genre"/> <br/>
    description: <input type="text" name="description"/> <br/>
    duration: <input type="number" name="duration"/> <br/>
    startRelease: <input type="date" name="startRelease"/> <br/>
    finishRelease: <input type="date" name="finishRelease"/> <br/>
    posterUrl: <input type="text" name="posterUrl"/> <br/>
    trailerUrl: <input type="text" name="trailerUrl"/> <br/>
    ID: <input type="number" name="id"/> <br/>
    <input type="submit" value="Update" /><br/>
    <br/>
</form>
        <h3>Удалить фильм</h3>
<form name="movieDelete" method="post" action="${pageContext.servletContext.contextPath}/adminDelete">
    ID: <input type="number" name="id"/> <br/>
    <input type="submit" value="Delete" /><br/>
    <br/>
</form>
</body>
</html>