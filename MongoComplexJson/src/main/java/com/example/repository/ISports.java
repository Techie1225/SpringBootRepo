package com.example.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.Sports;

public interface ISports extends MongoRepository<Sports, Integer> {

	

	
}
