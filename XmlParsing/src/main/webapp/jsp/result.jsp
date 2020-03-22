<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.sessionLocale == null}">
    <c:set var="sessionLocale" value="en_US" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.sessionLocale}"/>
<fmt:setBundle basename="property/pagecontent"/>

<html>
<head>
    <title><fmt:message key="tittle"/></title>
</head>
<body>
<button onclick="history.back()"><fmt:message key="back"/></button>
<table border="3" width="100%" cellpadding="10">
    <tr align="center" bgcolor="#deb887">
        <th><fmt:message key="id"/></th>
        <th><fmt:message key="login"/></th>
        <th><fmt:message key="password"/></th>
        <th><fmt:message key="phoneNumber"/></th>
        <th><fmt:message key="birthDate"/></th>
        <th><fmt:message key="sex"/></th>
        <th><fmt:message key="premierDate"/></th>
        <th><fmt:message key="imgPath"/></th>
        <th><fmt:message key="description"/></th>
        <th><fmt:message key="country"/></th>
        <th><fmt:message key="category"/></th>
    </tr>
    <c:forEach var="elem" items="${res}" varStatus="status">
        <tr align="center">
            <td><c:out value="${ elem.id }"/></td>

            <c:choose>
                <c:when test="${elem.getClass().getSimpleName() == 'User'}">
                    <td><c:out value="${ elem.login }"/></td>
                    <td><c:out value="${ elem.password}"/></td>
                    <td><c:out value="${ elem.info.phoneNumber }"/></td>
                    <td><c:out value="${ elem.info.birthDate }"/></td>
                    <td><c:out value="${ elem.info.sex }"/></td>
                    <td><c:out value="-"/></td>
                    <td><c:out value="-"/></td>
                </c:when>
                <c:when test="${elem.getClass().getSimpleName() == 'Serial'}">
                    <td><c:out value="-"/></td>
                    <td><c:out value="-"/></td>
                    <td><c:out value="-"/></td>
                    <td><c:out value="${ elem.name }"/></td>
                    <td><c:out value="${ elem.premierDate }"/></td>
                    <td><c:out value="${ elem.imgPath }"/></td>
                    <td><c:out value="${ elem.description }"/></td>
                    <td><c:out value="${ elem.country }"/></td>
                    <td><c:out value="${ elem.category }"/></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="${ elem.login }"/></td>
                    <td><c:out value="${ elem.password}"/></td>
                    <td><c:out value="${ elem.info.phoneNumber }"/></td>
                    <td><c:out value="${ elem.info.birthDate }"/></td>
                    <td><c:out value="${ elem.info.sex }"/></td>
                    <td><c:out value="${ elem.name }"/></td>
                    <td><c:out value="${ elem.premierDate }"/></td>
                    <td><c:out value="${ elem.imgPath }"/></td>
                    <td><c:out value="${ elem.description }"/></td>
                    <td><c:out value="${ elem.country }"/></td>
                    <td><c:out value="${ elem.category }"/></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
