<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="block">
    <form name="login_form" action="j_spring_security_check" method="post">
        <table class="person_form_table">
            <tr>
                <td colspan="2">
                    <p class="status_message"><fmt:message key="msg.login" /></p>
                <td>
            <tr>
            <tr>
                <td>
                    <label for="username"><fmt:message key="label.username" /></label>
                </td>
                <td>
                    <input type="text" name="j_username" />
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password"><fmt:message key="label.password" /></label>
                </td>
                <td>
                    <input type="password" name="j_password" />
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input class="command_button" type="submit" value="<fmt:message key="button.login" />" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <p class="login_description"><fmt:message key="login.description" /></p>
                </td>
            </tr>
        </table>
    </form>
</div>
