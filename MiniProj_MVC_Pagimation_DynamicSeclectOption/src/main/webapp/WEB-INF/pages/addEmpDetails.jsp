<%@page isELIgnored="false" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
</style>
<noscript>
	<h3 style="align: center color:red bgcolor:cyan">Please enable
		JavaScript</h3>
</noscript>
<script language="JavaScript" src="JS/Validation.js">
	
</script>


<h1>Welcome</h1>

<form:form modelAttribute="emp"
	onsubmit="return ValidationFunction(this)" name="frm">
	<b>Employee Name &nbsp; &nbsp;: &nbsp; &nbsp;</b>
	<form:input path="emp_name" id="name" />
	<form:errors cssStyle="color:red" path="emp_name" />
	<span id="nameErr"></span>
	<br>
	<b>Designation &nbsp; &nbsp;: &nbsp; &nbsp;</b>
	<form:input path="emp_job" id="job" />
	<form:errors cssStyle="color:red" path="emp_job" />
	<span id="jobErr"></span>
	<br>
	<b>Employee Salary&nbsp; &nbsp;: &nbsp; &nbsp;</b>
	<form:input path="emp_Salary" id="Salary" />
	<form:errors cssStyle="color:red" path="emp_Salary" />
	<span id="SalaryErr"></span>
	<br>




	<script language="JavaScript">
		function statesfun() {
			alert("Onchange");
			frm.action = "statesurl";
			frm.submit();
		}

		function ChangeActionFun() {
			alert("change action  ChangeActionFun()");
			frm.action = "add";
			frm.submit();
		}
		
		function dateval() {
		    var dv = document.getElementById("DOJ");
		    a = val.split("-").reverse().join("-");
		    dv.type = "text";
		    dv.value = a;
		}
	</script>
	<b>Select the Country&nbsp; &nbsp;: &nbsp; &nbsp;</b>
	<form:select path="employeecountry" onchange="statesfun()">
		<form:options items="${CountryName}" />
	</form:select>
	<br>

	<b>Select the State&nbsp; &nbsp;: &nbsp; &nbsp;</b>
	<form:select path="countrystate">
		<form:options items="${ListOfStates}" />
	</form:select>
	<br>

	<form:hidden path="vflag" id="flag" />
	<b>DOJ&nbsp; &nbsp;: &nbsp; &nbsp;</b>
	<%-- <form:input path="DOJ" type="date" pattern="dd-MM-yyyy" /> --%>
	<form:input path="DOJ" type="date" onchange="dateval()" name="input1"  />
	<br>
	<br>
	<input type="submit" value="Register Employee"
		onclick="ChangeActionFun()" />

</form:form>
