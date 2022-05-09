package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
	//Do not use _ in DTO for the propertyname while using sort in @PageableDefault
	public String showTheReports(
			@PageableDefault(page = 0, size = 4,  sort={"DOJ","countrystate"}, direction=Sort.Direction.ASC )Pageable pageable, 
			Map<String, Object> map) {
		//System.out.println("In report URL");
		Page<Employee_dto> page = eMPService.getTheRecords(pageable);
System.out.println("After Record collection");
		map.put("EmpTab", page);
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
		//System.out.println("EmployeeController.addToEmployeeTable()");

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
		
		//System.out.println("**********************" + emp.getEmp_no());
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
		//System.out.println("*******************" + emp_no);
		Employee_dto li = eMPService.selectByTheEmpNO(emp_no).get();

		BeanUtils.copyProperties(li, emp);

		return "editEmpDetails";

	}

	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute Employee_dto updateEmp, Map<String, Object> map, Pageable pageable) {

		eMPService.updateTheRecords(updateEmp);

		Page<Employee_dto> page = eMPService.getTheRecords(pageable);
		map.put("EmpTab", page);
		return "show_report";

	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam int emp_no, Map<String, Object> map,Pageable pageable) {
		//System.out.println("*******************" + emp_no);
		eMPService.deleteQuery(emp_no);

		Page<Employee_dto> page = eMPService.getTheRecords(pageable);
		map.put("EmpTab", page);
		return "show_report";

	}
	
	@ModelAttribute("CountryName")
	 public Set<String> countriesAutopopulate() {
		
		 Set<String> Country = eMPService.collectContries();
		 //System.out.println(Country.toString());
		 return Country;
	 }
	
	@PostMapping("/statesurl")
	public String states(@RequestParam("employeecountry") String employeecountry, 
								@ModelAttribute("emp") Employee_dto emp, Map<String,Object> map)
	{
		System.out.println("In statesurl states()"+employeecountry);
		List<String> st=eMPService.countryStates(employeecountry);
		System.out.println(st);
		map.put("ListOfStates",st);
		return "addEmpDetails";
	}

	@InitBinder
	public void stringTodateConv(WebDataBinder web) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf+"Date formatte----------");
		web.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
}
