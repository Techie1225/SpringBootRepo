package com.example.entity;




import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="studentReportCard")
public class OExamResult {
	@Id
	private Integer id;
	private LocalDate dob;
	private double percentage;
	private Integer semester;
	private String status;

	
}
