<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="cm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<br>
<cm:form modelAttribute="jsdata" enctype="multipart/form-data">
<table border="0" bgcolor="cyan" align="center">
<tr>
<td>Name  </td>
<td><cm:input path="jsname"></cm:input></td>
</tr>
<tr>
<td>Address  </td>
<td><cm:input path="jsaddress"></cm:input></td>
</tr>
<tr>
<td>resume  </td>
<td><cm:input type="file" path="jsresume"></cm:input></td>
</tr>
<tr>
<td>photo  </td>
<td><cm:input type="file" path="jsphoto"></cm:input></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Register"></td>
</tr>
</table>
</cm:form>

</body>
</html>