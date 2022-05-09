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
		<c:when test="${!empty EmpTab.getContent()}">

			<table border=1 align="center">
				<tr>
				<th>S.NO</th>
					<th>Employee Name</th>
					<th>Designation</th>
					<th>Employee Salary</th>
					<th>Country</th>
					<th>State</th>
					<th>Update</th>
					<th>Delete</th>
					<th>Date Of Joining</th>
				</tr>
				<c:forEach var="emp1" items="${EmpTab.getContent()}">
				<tr>
				<td>${emp1.emp_no}</td>
				<td>${emp1.emp_name}</td>
				<td>${emp1.emp_job}</td>
				<td>${emp1.emp_Salary}</td>
				<td>${emp1.employeecountry}</td>
				<td>${emp1.countrystate}</td>
				
				<td><a href="edit?emp_no=${emp1.emp_no}"><i class="fa fa-edit"></i></a></td>
				
				<td><a href="delete?emp_no=${emp1.emp_no}"><i class="fa fa-trash"></i></a></td>
				<td>${emp1.DOJ}</td>
				</tr>
				</c:forEach>

			</table>
		</c:when>
		<c:otherwise>
		<h3>No Records Found</h3>
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty EmpNo}">
                                <h1>Record saved with the id:: ${EmpNo}</h1>
                             </c:if>
                             
     <p align="center">
     
     <c:if test="${EmpTab.hasPrevious()}">
     <a href="report?page=${EmpTab.getPageable().getPageNumber()-1}">Previous</a>
     </c:if>
     
     <c:if test="${!EmpTab.isFirst()}">
     <a href="report?page=0">first</a>
     </c:if>
     
     <c:forEach var="page" begin="1" end="${EmpTab.getTotalPages()}" step="1">
     [<a href="report?page=${page-1}">${page}</a>]
     </c:forEach>
     
     <c:if test="${!EmpTab.isLast()}">
     <a href="report?page=${EmpTab.getTotalPages()-1}">last</a>
     </c:if>
     
     <c:if test="${EmpTab.hasNext()}">
     <a href="report?page=${EmpTab.getPageable().getPageNumber()+1}">Next</a>
     </c:if>
     
     </p>
	
	<a align="center" href="add">Add Employee</a>

</body>
</html>