package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dto.job_seeker_info;
public interface Ijob_repo extends JpaRepository<job_seeker_info, Integer> {
	
	@Query("SELECT resumepath FROM job_seeker_info WHERE jsid=:Id")
	public String fetchResumebyId(Integer Id);
	@Query("SELECT photopath FROM job_seeker_info WHERE jsid=:Id")
	public String fetchPhotobyId(Integer Id);


}
