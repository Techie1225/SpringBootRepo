package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.Repository.MovieRepoository;
import com.example.Repository.MovieRepoository2;
import com.example.entity.Movie;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepoository movieObj;
	
	@Autowired
	private MovieRepoository2 movieObj2;
	

	@Override
	public Page<Movie> Pagination(Integer PageNo, Integer PageSize, boolean flag, String... props) {
		Pageable pageable=PageRequest.of(PageNo,PageSize,Sort.by(flag?Direction.ASC:Direction.DESC,props));
		
		Page<Movie> page=movieObj.findAll(pageable);
		return page;
	}

	@Override
	public List<Movie> SearchMovies(Movie movie, boolean flag, String... props) {
		Example example=Example.of(movie);
		List<Movie> list=movieObj2.findAll(example,Sort.by(flag?Direction.ASC:Direction.DESC,props));
		return list;
	}

	
	

}
