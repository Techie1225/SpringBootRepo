package com.example.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Employee_Collection_Id")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDetails {

	@Id
	@GeneratedValue
	//@Column(name="idprofile")
	private Integer eid;
	
	private String name;
	
	@ElementCollection 
	@CollectionTable(name="Emp_friends")
	@JoinColumn(name="Emp_Id",referencedColumnName="eid")
	@OrderColumn(name="index_col")
	@ListIndexBase(value=1)
	private List<String> Friend_Name;
	
	@ElementCollection 
	@CollectionTable(name="Emp_pnNum",joinColumns=@JoinColumn(name="Emp_Id",referencedColumnName="eid"))	
	private Set<Long> Ph_num;
	
	@ElementCollection 
	@CollectionTable(name="Emp_CardDetails",joinColumns=@JoinColumn(name="Emp_Id",referencedColumnName="eid"))	
	@MapKeyColumn(name="Card_Type")
	private Map<String,String> Id_Details;
}
