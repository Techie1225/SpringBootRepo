package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Employee_dto;

public interface EmpRepo extends JpaRepository<Employee_dto, Integer> {
	

}
