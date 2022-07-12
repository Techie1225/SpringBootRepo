package com.example.entity;




import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IExamResult {
	private Integer id;
	private String dob;
	private double percentage;
	private Integer semester;

	
}
