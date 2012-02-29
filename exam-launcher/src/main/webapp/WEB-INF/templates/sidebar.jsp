<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="block">
    <div id="sidebar_content">
        <p><fmt:message key="site.sidebar.title" /></p>
        <a href="<c:url value="/person/form.html" />"><fmt:message key="button.create" /></a>
        <a href="<c:url value="/person/search.html" />"><fmt:message key="button.search" /></a>
    </div>
</div>