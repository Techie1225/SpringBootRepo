<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	

<noscript>
<h3 style="align:center color:red bgcolor:cyan">Please enable JavaScript</h3>
</noscript>
<script language="JavaScript" src="JS/Validation.js">

</script>

<h1>Welcome</h1>

<form:form modelAttribute="emp" onsubmit=" return ValidationFunction(this) ">
<h3>Employee Name: </h3>
<form:input path="emp_name" id="name"/><form:errors cssStyle="color:red" path="emp_name"/><span id="nameErr"></span><br>
<h3>Designation: </h3>
<form:input path="emp_job" id="job"/><form:errors cssStyle="color:red" path="emp_job"/><span id="jobErr"></span><br>
<h3>Employee Salary: </h3>
<form:input path="emp_Salary" id="Salary"/><form:errors cssStyle="color:red" path="emp_Salary"/><span id="SalaryErr"></span><br></br>
<form:hidden path="vflag" id="flag"/>
<input type="submit" value="Register Employee "/>

</form:form>
