package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Employee_dto;
import com.example.repo.EmpRepo;



@Service
public class EMPService {
	
	@Autowired
	EmpRepo empRepo;
	
	

	public Page<Employee_dto> getTheRecords(Pageable pageable) {
		System.out.println("In getTheRecords(Pageable pageable)");
		Page<Employee_dto> pageobj=empRepo.findAll(pageable);
		System.out.println(pageobj);
		return pageobj;
		
	}
	
	

	public String saveTheRecords(Employee_dto employee_dto) {
		// TODO Auto-generated method stub

		return "Record inserted with the id"+empRepo.save(employee_dto).getEmp_no();
		
	}

	public Optional<Employee_dto> selectByTheEmpNO(int emp_no) {
		// TODO Auto-generated method stub
		return empRepo.findById(emp_no);
		
	}



	public void updateTheRecords(Employee_dto updateEmp) {
		// TODO Auto-generated method stub
		empRepo.save(updateEmp);
	}


	public void deleteQuery(int emp_no) {
		// TODO Auto-generated method stub
		empRepo.deleteById(emp_no);
	}

	public Set<String> collectContries() {
		Locale[] locale = Locale.getAvailableLocales();
		Set<String> contriesSet=  new TreeSet<String>();
		
			for(Locale l:locale) {
				if(l!=null && !(l.equals("")) && l.toString().length()!=0) {
					contriesSet.add(l.getDisplayCountry());
					/*
					 * if(l.getDisplayCountry().toString().length()!=0) {
					 * contriesSet.add(l.getDisplayCountry()); }
					 */
				}
			}
			//System.out.println(contriesSet);
			return contriesSet;	
	}

@Autowired
private Environment env;
	public List<String> countryStates(String country) {
		String st=env.getRequiredProperty(country);
		System.out.println("77777777777777777777777777777"+st);
		List<String> li=Arrays.asList(st.split(","));
		return li;
	}
	

}
