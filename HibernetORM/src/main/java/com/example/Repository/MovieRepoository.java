package com.example.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Movie;

public interface MovieRepoository extends CrudRepository<Movie, Integer> {

}
