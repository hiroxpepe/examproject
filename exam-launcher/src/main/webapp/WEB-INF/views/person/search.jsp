<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>

<div class="block">
    <h1 class="content_title"><fmt:message key="person.search.title" /></h1>
    
    <!-- if there is no data -->
    <c:if test="${empty persons}">
        <p class="error_message"><fmt:message key="person.search.msg.nodata" /></p>
    </c:if>
    
    <!-- if there is data -->
    <c:if test="${not empty persons}">
        <table class="person_search_table">
            <tr>
                <th><fmt:message key="person.search.label.firstname" /></th>
                <th><fmt:message key="person.search.label.lastname" /></th>
                <!-- if the ROLE_ADMIN authority, will allow the CRUD operation.-->
                <sec:authorize ifAllGranted="ROLE_ADMIN">
                    <th><fmt:message key="person.search.label.operation" /></th>
                </sec:authorize>
            </tr>

            <!-- creat row -->
            <c:forEach var="person" items="${persons}" varStatus="status">
                <tr>
                    <!-- create a url for edit -->
                    <c:url var="editUrl" value="/person/form.html">
                        <c:param name="id" value="${person.id}" />
                    </c:url>

                    <!-- create a url for delete -->
                    <c:url var="deleteUrl" value="/person/delete.html" />

                    <!-- create an id value for delete -->
                    <c:set var="personFormId" value="person${status.index}" />

                    <!-- create a form for delete -->
                    <form id="${personFormId}" action="${deleteUrl}" method="POST">
                        <input id="id" name="id" type="hidden" value="${person.id}" />
                    </form>

                    <!-- create columns -->
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    
                    <!-- if the ROLE_ADMIN authority, will allow the CRUD operation.-->
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
                        <td>
                            <!-- for edit link -->
                            <a href='<c:out value="${editUrl}" />'>
                                <fmt:message key="button.edit" />
                            </a>
                            <!-- for delete link -->
                            <a href="javascript:document.forms['${personFormId}'].submit();">
                                <fmt:message key="button.delete" />
                            </a>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>