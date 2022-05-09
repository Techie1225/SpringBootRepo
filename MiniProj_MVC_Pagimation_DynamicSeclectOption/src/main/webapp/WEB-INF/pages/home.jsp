<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue;text-align:center"><spring:message code="welcomeMsg"/></h1>

<a align="center" href="report">Generate report Card</a>
<br/><br/><br/>

<h1>Current active Locale is::${pageContext.response.locale}</h1>

<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formatDate var="locdate" value="${dt}" type="date" dateStyle="SHORT" />
<h4>Formatted Date :: ${locdate}</h4>
<fmt:formatDate var="loctime" value="${dt}" type="time" timeStyle="FULL" />
<h4>Formatted time :: ${loctime}</h4>
<fmt:formatNumber var="num" value="678000000" type="number"/>
<h4>Formatted Number :: ${num}</h4>
<fmt:formatNumber var="currency" value="678000000" type="currency"/>
<h4>Formatted Number :: ${currency}</h4>
<fmt:formatNumber var="percent" value="678000000" type="PERCENT"/>
<h4>Formatted Number :: ${percent}</h4>

<p align="center">
<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="?lang=hi_IN">हिन्दी</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="?lang=te_IN">తెలుగు</a>&nbsp;&nbsp;&nbsp;&nbsp;
</p>

</body>
</html>