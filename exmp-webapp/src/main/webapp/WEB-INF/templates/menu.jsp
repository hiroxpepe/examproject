<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="block menu-content">
    <div class="menu-bar">
        <a href="<c:url value="/" />"><fmt:message key="link.home" /></a>
        <a href="<c:url value="/login.html" />"><fmt:message key="link.login" /></a>
        <a href="<c:url value="/logout.html" />"><fmt:message key="link.logout" /></a>
    </div>
</div>