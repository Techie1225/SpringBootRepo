package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.example.dto.job_seeker_info;
import com.example.repo.Ijob_repo;

@Component
public class job_service implements Ijob_service {

	@Autowired
	private Ijob_repo job_repo;
	@Override
	public int savethedata(job_seeker_info jobseekerinfo) {
		// TODO Auto-generated method stub
		return job_repo.save(jobseekerinfo).getJsid();
	}
	
	@Override
	public List<job_seeker_info> FetchTheRecords() {
		return job_repo.findAll();
	}
	
	@Override
	public String getResumePathById(Integer Id) {
		
		return job_repo.fetchResumebyId(Id);
	}
	
	@Override
	public String getPhotoPathById(Integer Id) {
		
		return job_repo.fetchPhotobyId(Id);
	}

}
