package com.example.entity;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class person {
	@Id
private Long pid;
private String name;
private String adress;
private Set<Sports> sports;
private Map<String,Medals> medals;



}
