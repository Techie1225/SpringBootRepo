package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ProfileDetails;

public interface IProfileRepo extends JpaRepository<ProfileDetails, Integer> {

	
}
