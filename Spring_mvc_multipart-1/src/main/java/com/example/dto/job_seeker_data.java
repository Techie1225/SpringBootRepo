package com.example.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class job_seeker_data implements Serializable {
	
	private Integer jsid;
	private String jsname;
	private String jsaddress;
	private MultipartFile jsresume;
	private MultipartFile jsphoto;

}
