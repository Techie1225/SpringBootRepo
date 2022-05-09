package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="profile")
@Entity
@Data
@RequiredArgsConstructor
public class ProfileDetails {

	@Id
	@GeneratedValue
	//@Column(name="idprofile")
	private int id;
	@NonNull
	
	private String Pname;
	@NonNull
	private LocalDate DOB;
	/*
	 * @NonNull private LocalTime CurrentTime;
	 */
	@NonNull
	private LocalDateTime DtandTm;
}
