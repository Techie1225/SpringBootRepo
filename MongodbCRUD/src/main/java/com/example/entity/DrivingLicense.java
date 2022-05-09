package com.example.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class DrivingLicense implements Serializable {
	
	

		@Id
		@NonNull
		private Long LicenseNo;
		@NonNull
		private String type;
		@NonNull
		private LocalDate expiryDate;
		private ProfileDetails pdetails;
	
}
