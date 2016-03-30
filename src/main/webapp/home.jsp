
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>title</title>
</head>

<body>
<h1>Home</h1>
<p>Hello, ${sessionScope.user}</p>

<a href="<c:url value="/logout" />">logout</a>
</body>
</html>
