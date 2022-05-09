package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="Theater")
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	@NonNull
	@Column(name="MovieName",length=20)
	private String mname;
	@NonNull
	private float mrating;
	@NonNull
	private String Year;
	
	}


