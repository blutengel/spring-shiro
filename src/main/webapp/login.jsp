
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>title</title>
</head>

<body>
<h1>Login</h1>
<form action="<c:url value="/login"/>" method="post">
    username <input type="text" name="username">
    password <input type="password" name="password">
    <input type="submit" value="login">
</form>
</body>
</html>
