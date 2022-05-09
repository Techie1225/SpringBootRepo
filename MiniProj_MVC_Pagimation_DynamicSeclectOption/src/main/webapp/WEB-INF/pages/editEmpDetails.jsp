


<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<h1>Update Profile</h1>
<form:form modelAttribute="emp">

<h3>Employee Name: </h3>
<form:input path="emp_name" /><form:errors cssStyle="color:red" path="emp_name"/><br>
<h3>Designation: </h3>
<form:input path="emp_job"/><form:errors cssStyle="color:red" path="emp_job"/><br>
<h3>Employee Salary: </h3>
<form:input path="emp_Salary"/><form:errors cssStyle="color:red" path="emp_Salary"/><br></br>

<input type="submit" value="Save"/>

</form:form>