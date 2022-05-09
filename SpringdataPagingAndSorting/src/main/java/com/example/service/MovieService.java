package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.entity.Movie;

public interface MovieService {

	public Page<Movie> Pagination(Integer PageNo,Integer PageSize,boolean flag,String...props);
	public List<Movie> SearchMovies(Movie movie,boolean flag,String...props);

}
