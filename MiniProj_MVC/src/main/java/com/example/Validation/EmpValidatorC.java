package com.example.Validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.model.Employee_dto;

@Component
public class EmpValidatorC implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Employee_dto.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Employee_dto emp=(Employee_dto) target;
		
		
		
		
		//
		if(emp.getEmp_job().equals("") ||emp.getEmp_job()==null ||emp.getEmp_job().length()==0) {
			errors.rejectValue("emp_job", "empdesg.required");
		}
		else if(emp.getEmp_job().length()>10) {
			errors.rejectValue("emp_job", "empdesg.maxlength");
		}
		
		System.out.println("before salary");
 if (errors.hasFieldErrors()) {
			System.out.println("In .hasFieldErrors()");
			//errors.rejectValue("emp_salary", "emp_Salary.mismatch");
			if(emp.getEmp_name().equals("") ||emp.getEmp_name()==null ||emp.getEmp_name().length()==0) {
				errors.rejectValue("emp_name", "empname.required");
			}
			else if(emp.getEmp_name().length()>15) {
				errors.rejectValue("emp_name", "empname.maxlength");
			}
		} 


 System.out.println(errors.hasFieldErrors("emp_name"));

 System.out.println(emp.getEmp_Salary());
 if(errors.hasFieldErrors("emp_Salary")) {
	 System.out.println("************************");
 }
 else if(emp.getEmp_Salary()==null  ) {
		
			errors.rejectValue("emp_Salary", "empsal.required");
		}
		else if(emp.getEmp_Salary()<0 ||emp.getEmp_Salary()>1000 ) {
			errors.rejectValue("emp_Salary", "empsal.range");
		
		}

	}

}
