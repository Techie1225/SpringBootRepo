<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1>Emp Details</h1>
	<c:choose>
		<c:when test="${!empty EmpTab}">

			<table border=1>
				<tr>
				<th>S.NO</th>
					<th>Employee Name</th>
					<th>Designation</th>
					<th>Employee Salary</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="emp" items="${EmpTab}">
				<tr>
				<td>${emp.emp_no}</td>
				<td>${emp.emp_name}</td>
				<td>${emp.emp_job}</td>
				<td>${emp.emp_Salary}</td>
				<td><a href="edit?emp_no=${emp.emp_no}"><i class="fa fa-edit"></i></a></td>
				
				<td><a href="delete?emp_no=${emp.emp_no}"><i class="fa fa-trash"></i></a></td>

				</tr>
				</c:forEach>

			</table>
		</c:when>
		<c:otherwise>
		<h3>No Records Found</h3>
		</c:otherwise>
	</c:choose>
	<%-- <c:if test="${!empty emloyeeNo}"> --%>
                                <h1>Record saved with the id:: ${emloyeeNo}</h1>
                            <%--  </c:if> --%>
	
	<a align="center" href="add">Add Employee</a>

</body>
</html>