<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
    

<h1>List Of Applicants</h1>
<C:choose>
<C:when test="${!empty entry}">
<table border="1" align="center" color=cyan>
<tr>
<th>ID</th><th>Name</th><th>Address</th><th>Resume</th><th>Photo</th>
</tr>


<C:forEach var="temp" items="${entry}">
<tr>
<td>${temp.jsid}</td>
<td>${temp.jsname}</td>
<td>${temp.address}</td>
<td><a href="download?jsid=${temp.jsid}&type=resume">Download Resume</a></td>
<td><a href="download?jsid=${temp.jsid}&type=photo">Download Photo</a></td>
</tr>
</C:forEach>
</table>
</C:when>
<C:otherwise>
<h3 sytle="color:red">No Records Found</h3>
</C:otherwise>
</C:choose>

