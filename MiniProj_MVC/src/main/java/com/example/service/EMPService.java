package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee_dto;
import com.example.repo.EmpRepo;



@Service
public class EMPService {
	
	@Autowired
	EmpRepo empRepo;
	
	

	public List<Employee_dto> getTheRecords() {
		return empRepo.findAll();
		
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

	

}
