package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.Medals;

public interface IMedals extends MongoRepository<Medals, String> {

}
