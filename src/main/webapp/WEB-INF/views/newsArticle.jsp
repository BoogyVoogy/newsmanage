<%--
  Created by IntelliJ IDEA.
  User: AMG
  Date: 27.03.2016
  Time: 12:21
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
    <title><spring:message code="label.news" /></title>
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


<h3><spring:message code="label.news" /></h3>
<c:if test="${!empty newsList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.newsname" /></th>
            <th><spring:message code="label.newscategory" /></th>
            <th><spring:message code="label.newsdate" /></th>

        </tr>
        <c:forEach items="${newsList}" var="news">
            <tr>
                <td>${news.title}</td>
                <td>${category}</td>
                <td>${news.getSimpleDate()}</td>

            </tr>


        </c:forEach>
    </table>
    <h3>Содержание</h3>
    <c:forEach items="${newsList}" var="news">
    <div class="descr">${news.descr}</div>
    </c:forEach>
</c:if>
</body>
</html>
