package com.example.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data

@RequiredArgsConstructor
public class ProfileDetails implements Serializable {

	@Id

	private String id;
	@Nullable
	private String touristName;
	@NonNull
	private String passpertNo;
	@NonNull
	private Float age;
	@NonNull
	private Integer registration_id;

	private DrivingLicense DLicense;
	
}
