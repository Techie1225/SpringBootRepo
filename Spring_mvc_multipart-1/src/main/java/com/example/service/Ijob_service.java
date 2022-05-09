package com.example.service;

import java.util.List;

import com.example.dto.job_seeker_info;

public interface Ijob_service {
	
	public int savethedata(job_seeker_info jobseekerinfo);

	List<job_seeker_info> FetchTheRecords();

	String getResumePathById(Integer Id);

	String getPhotoPathById(Integer Id);

}
