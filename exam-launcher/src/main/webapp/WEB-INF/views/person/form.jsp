<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="block">
    <h1 class="content_title"><fmt:message key="person.form.title" /></h1>

    <!-- if there is a message to display. -->
    <c:if test="${not empty statusMessageKey}">
        <p class="status_message"><fmt:message key="${statusMessageKey}" /></p>
    </c:if>

    <!-- create url -->
    <c:url var="url" value="/person/form.html" />

    <form:form action="${url}" commandName="personForm">
        <form:hidden path="id" />
        <table class="person_form_table">
            <tr>
                <td>
                    <label for="firstName"><fmt:message key="person.form.firstName" /></label>
                </td>
                <td>
                    <form:input path="firstName" />
                </td>
            </tr>
            <tr>
                <td>
                    <label for="lastName"><fmt:message key="person.form.lastName" /></label>
                </td>
                <td>
                    <form:input path="lastName" />
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input class="command_button" name="submit" type="submit" value="<fmt:message key="button.save" />"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>