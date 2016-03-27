<%--
  Created by IntelliJ IDEA.
  User: AMG
  Date: 26.03.2016
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /></title>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>
<ul class="css-menu">
    <li>
        <a href="<c:url value="/news" />">
            <spring:message code="label.news" />
        </a></li>
    <li>
        <a href="<c:url value="/category" />">
            <spring:message code="label.category" />
        </a></li>
    <li>
        <a href="<c:url value="/createarticle" />">
            <spring:message code="label.create" />
        </a></li>
    <li>
        <a href="<c:url value="/search" />">
            <spring:message code="label.search" />
        </a></li>
</ul>


<form:form method="post" action="addcategory" commandName="category">

<table>
    <tr>
        <td><form:label path="cname">
            <spring:message code="label.cname" />
        </form:label>
        </td>
    </tr>
    <tr>
        <td><form:input path="cname" /></td>
    </tr>
    <tr>
        <td><input type="submit"
                               value="<spring:message code="label.addcategory"/>" /></td>
    </tr>
</table>

</form:form>

<h3><spring:message code="label.category" /></h3>

<c:if test="${!empty categoryList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.c_id" /></th>
            <th><spring:message code="label.category" /></th>

        </tr>



        <c:forEach items="${categoryList}" var="category">
            <tr>
                <td>${category.id}</td>
                <td><a href="news/${category.id}">${category.cname}</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
