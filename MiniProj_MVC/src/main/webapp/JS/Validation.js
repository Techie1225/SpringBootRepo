 
function ValidationFunction(frm){

	document.getElementById("nameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("SalaryErr").innerHTML="";
		
	let ename=document.getElementById("name").value;

	let job=document.getElementById("job").value;
	let salary=document.getElementById("Salary").value;

	let flag=true;

	if(ename==""){
		document.getElementById("nameErr").innerHTML="Employee Name is required(Client Side validation)";
		flag=false;
	}
	else if(ename.length>15){
		document.getElementById("nameErr").innerHTML="Name must not exceed 15Characters(Client Side validation)";
		flag=false;
	}

	if(job==""){
		document.getElementById("jobErr").innerHTML="designation field is required(Client Side validation)";
		flag=false;
	}
	else if(job.length>10){
		document.getElementById("jobErr").innerHTML="Designation must not exceed 10Characters(Client Side validation)";
		flag=false;
	}

	if(salary==""){
		document.getElementById("SalaryErr").innerHTML="salary is required(Client Side validation)";
		flag=false;
	}
	else if(salary<0 || salary>10000000){
		document.getElementById("SalaryErr").innerHTML="Salary must be Within the range of 0 and 1Cr";
		flag=false;
	}
	else if(isNaN(salary)){
		document.getElementById("SalaryErr").innerHTML="Salary must be a Numeric Value";
		flag=false;
	}
	console.log("*******************"+flag);	
	document.getElementById("flag").value="yes";
	console.log(flag)
	/*if(flag==false)
	{		
		return event.preventDefault();
		
	}
	else{
		return flag;
	}*/
	return flag;
	
}