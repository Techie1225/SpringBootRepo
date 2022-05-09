package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Movie;

public interface MovieService {

	public String RegisteredStatus(Movie movie);

	public long FindCount(Movie movie);

	public boolean ChechWhetherExists(Movie movie);

	public void delete(Movie movie);

	public Iterable<Movie> selectall();

	public Iterable<Movie> SearchByIds(List<Integer> identity);

	public Optional<Movie> SearchById(Integer identity);

	public String update(Integer mid, String name, float rating);
	
	public String deleteMultiplerecords(Iterable<Integer> id);
	public String clearAll();
	public String insertmultplerecords(List<Movie> movie);

}
