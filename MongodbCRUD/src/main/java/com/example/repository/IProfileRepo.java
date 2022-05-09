package com.example.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.ProfileDetails;

public interface IProfileRepo extends MongoRepository<ProfileDetails, String> {

	List<ProfileDetails> findByPasspertNoOrderByTouristNameAsc(String passport);

	
}
