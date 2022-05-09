package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Validation.EmpValidatorC;
import com.example.model.Employee_dto;
import com.example.service.EMPService;

@Controller
@SessionAttributes
public class EmployeeController {

	@Autowired
	EMPService eMPService;

	@Autowired
	EmpValidatorC validate;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/report")
	public String showTheReports(Map<String, Object> map, Model mod) {
		List<Employee_dto> li = eMPService.getTheRecords();
		map.put("EmpTab", li);
		//Using Model.asMap() for persist message of latest inserted record
		Integer empNo = (Integer) mod.asMap().get("EmpNo");
		map.put("emloyeeNo", empNo);
		return "show_report";
	}

	@GetMapping("/add")
	public String registerEmployee(@ModelAttribute("emp") Employee_dto emp) {
		emp.setEmp_job("Java");
		return "addEmpDetails";

	}

	@PostMapping("/add")
	public String addToEmployeeTable(RedirectAttributes att, @ModelAttribute("emp") Employee_dto emp, 
			BindingResult errors) {

		// map.put("msg","Employee registered Succesfully");
		System.out.println("EmployeeController.addToEmployeeTable()");

		/*
		 * if (errors.hasFieldErrors()) {
		 * 
		 * return "addEmpDetails"; }
		 */
		if(emp.getVflag().equalsIgnoreCase("no")) {
			
		
		if (validate.supports(emp.getClass())) {		
			validate.validate(emp, errors);
			if (errors.hasErrors()) 
				return "addEmpDetails";
			}
		

		

		if (emp.getEmp_job().equalsIgnoreCase("Student")) {
			errors.reject("emp_job", "emp_job.reject");
			return "addEmpDetails";
		}
		}

		eMPService.saveTheRecords(emp);
		// List li =eMPService.getTheRecords();
		//Using FlashAttribute to disappear the id once the page was refreshed 
		att.addFlashAttribute("EmpNo", emp.getEmp_no());
		
		System.out.println("**********************" + emp.getEmp_no());
		return "redirect:report";

	}

	@GetMapping("/edit")
	public String editEmployee(@RequestParam int emp_no, @ModelAttribute Employee_dto emp, BindingResult errors) {
		if (validate.supports(emp.getClass())) {
			validate.validate(emp, errors);
			if (errors.hasErrors()) {

				return "addEmpDetails";
			}
		}

		if (errors.hasFieldErrors()) {
			return "addEmpDetails";
		}

		if (emp.getEmp_job().equalsIgnoreCase("Student")) {
			errors.reject("emp_job", "emp_job.reject");
			return "addEmpDetails";
		}
		System.out.println("*******************" + emp_no);
		Employee_dto li = eMPService.selectByTheEmpNO(emp_no).get();

		BeanUtils.copyProperties(li, emp);

		return "editEmpDetails";

	}

	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute Employee_dto updateEmp, Map<String, Object> map) {

		eMPService.updateTheRecords(updateEmp);

		List li = eMPService.getTheRecords();
		map.put("EmpTab", li);
		return "show_report";

	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam int emp_no, Map<String, Object> map) {
		System.out.println("*******************" + emp_no);
		eMPService.deleteQuery(emp_no);

		List li = eMPService.getTheRecords();
		map.put("EmpTab", li);
		return "show_report";

	}

}
