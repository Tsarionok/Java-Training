<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="context"
       value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css"
          href="${context}/css/login.css"/>
</head>
<body>

<div class="login">
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="login"/>
        <p>
            Login:
            <input type="text" name="login" value=""/>
        </p>
        <p>
            <jsp:text>Password:</jsp:text>
            <input type="password" name="password" value=""/>
        </p>
        <p>${errorLoginPassMessage}</p>
        <p>${wrongAction}</p>
        <p>${nullPage}</p>
        <input type="submit" value="Log in"/>
    </form>
</div>

</body>
</html>