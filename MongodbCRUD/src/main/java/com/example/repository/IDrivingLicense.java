package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.DrivingLicense;

public interface IDrivingLicense extends MongoRepository<DrivingLicense, Long> {

}
