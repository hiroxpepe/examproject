<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>

<div class="block search-content">
    <h1 class="content-title"><fmt:message key="person.search.title" /></h1>
    
    <!-- if there is no data, display a message. -->
    <c:if test="${empty persons}">
        <c:if test="${empty statusMessageKey}">
            <div class="error-block"><fmt:message key="person.search.msg.nodata" /></div>
        </c:if>
    </c:if>
        
    <!-- if there is a message to display. -->
    <c:if test="${not empty statusMessageKey}">
        <div class="status-block"><fmt:message key="${statusMessageKey}" /></div>
    </c:if>
    
    <!-- if there is data, display a table. -->
    <c:if test="${not empty persons}">
        <table class="person-search-table">
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
                    <!-- create an url for edit -->
                    <c:url var="editUrl" value="/person/form.html">
                        <c:param name="id" value="${person.id}" />
                    </c:url>

                    <!-- create an url for delete -->
                    <c:url var="deleteUrl" value="/person/delete.html" />

                    <!-- create an id value for delete -->
                    <c:set var="personFormId" value="person${status.index}" />

                    <!-- create a form for delete -->
                    <form id="${personFormId}" action="${deleteUrl}" method="POST">
                        <input id="id" name="id" type="hidden" value="${person.id}" />
                    </form>

                    <!-- create columns -->
                    <td><c:out value="${person.firstName}" /></td>
                    <td><c:out value="${person.lastName}" /></td>           
                    
                    <!-- if the ROLE_ADMIN authority, will allow the CRUD operation.-->
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
                        <td>
                            <!-- this is a link for edit -->
                            <a href='<c:out value="${editUrl}" />'>
                                <fmt:message key="button.edit" />
                            </a>
                            <!-- this is a link for delete -->
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