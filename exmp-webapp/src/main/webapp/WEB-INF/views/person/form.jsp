<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="block form-content">
    <h1 class="content-title"><fmt:message key="person.form.title" /></h1>

    <!-- create url -->
    <c:url var="url" value="/person/form.html" />

    <form:form action="${url}" commandName="personForm">
        <form:hidden path="id" />

        <!-- validation error div -->
        <form:errors path="*" cssClass="error-block" element="div" />
        
        <!-- a css naming rule is simply follow the path to jsp files. -->
        <table class="person-form-table">  
            <tr>
                <td>
                    <label for="firstName"><fmt:message key="person.form.label.firstname" /></label>
                </td>
                <td>
                    <form:input path="firstName" />
                </td>
            </tr>
            <tr>
                <td>
                    <label for="lastName"><fmt:message key="person.form.label.lastname" /></label>
                </td>
                <td>
                    <form:input path="lastName" />
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input class="command-button" name="submit" type="submit" value="<fmt:message key="button.save" />" />
                </td>
            </tr>
        </table>
    </form:form>
</div>