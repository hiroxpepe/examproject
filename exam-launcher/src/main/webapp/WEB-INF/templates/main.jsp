<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>" />
        <title><fmt:message key="site.title"/></title>
    </head>
    <body>
        <div id="container">
            <div id="menu">
                <tiles:insertAttribute name="menu" />
            </div>
            <div id="header">
                <tiles:insertAttribute name="header" />
            </div>
            <div id="sidebar">
                <tiles:insertAttribute name="sidebar"/>
            </div>
            <div id="content">
                <tiles:insertAttribute name="content" />
            </div>
            <div id="footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>
