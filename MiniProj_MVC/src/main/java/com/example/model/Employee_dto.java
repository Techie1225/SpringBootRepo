package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name="mini_emp")
@Data

  @SQLDelete(sql = "UPDATE mini_emp SET STATUS='inactive' WHERE emp_no=?")
  
  @Where(clause="STATUS <> 'inactive'")
 
public class Employee_dto {
	@Id
	@SequenceGenerator(name="gen", sequenceName="EMP_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator="gen", strategy=GenerationType.SEQUENCE)
	private Integer emp_no;
	private String emp_name;
	private String emp_job;
	private Float emp_Salary;
	
	private String vflag="no";
	 
	

	
}
