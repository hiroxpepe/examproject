<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="block footer-content">
    <div>
        <fmt:message key="label.locale" />:
        <c:url var="englishLocaleUrl" value="/index.html">
            <c:param name="locale" value="" />
        </c:url>
        <c:url var="japaneseLocaleUrl" value="/index.html">
            <c:param name="locale" value="jp" />
        </c:url>
        <c:url var="koreanLocaleUrl" value="/index.html">
            <c:param name="locale" value="kr" />
        </c:url>
        <a href='<c:out value="${englishLocaleUrl}" />'><fmt:message key="locale.english" /></a>
        <a href='<c:out value="${japaneseLocaleUrl}" />'><fmt:message key="locale.japanese" /></a>
        <a href='<c:out value="${koreanLocaleUrl}" />'><fmt:message key="locale.korean" /></a>
    </div>
    <div>
        <fmt:message key="site.footer.author" /> <fmt:message key="site.footer.copyright" />
    </div>
</div>