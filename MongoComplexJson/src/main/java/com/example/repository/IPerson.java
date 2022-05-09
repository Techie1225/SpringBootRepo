package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.person;

public interface IPerson extends MongoRepository<person, Long> {

}
