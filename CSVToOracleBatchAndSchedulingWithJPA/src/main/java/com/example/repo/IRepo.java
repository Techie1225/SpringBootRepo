package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OExamResult;

public interface IRepo extends JpaRepository<OExamResult, Integer> {

}
