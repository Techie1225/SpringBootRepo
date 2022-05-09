package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Movie;


public interface IMovieService {
	
	
	public List<Movie> searchById(int min,int max);

}
