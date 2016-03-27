<%--
  Created by IntelliJ IDEA.
  User: AMG
  Date: 27.03.2016
  Time: 14:58
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


<form:form method="post" action="addarticle" commandName="news">

    <table>
        <tr>
          <td><form:label path="title">
            <spring:message code="label.newsname" />
            </form:label></td>
             <td><form:input path="title" /></td>
         </tr>
        <tr>
            <td><form:label path="descr">
                <spring:message code="label.newstext" />
            </form:label></td>
            <td><form:textarea path="descr" /></td>
        </tr>
        <tr>
            <td><form:label path="title">
                <spring:message code="label.newscategory" />
            </form:label></td></td>
            <td>
                <form:select path="c_id">

                    <c:forEach items="${categoryList}" var="category">
                       <form:option value="${category.id}">${category.cname}</form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.addarticle"/>" /></td>
        </tr>

    </table>
</form:form>

</body>
</html>

