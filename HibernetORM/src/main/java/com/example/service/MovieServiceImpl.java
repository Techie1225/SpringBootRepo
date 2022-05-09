package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.MovieRepoository;
import com.example.entity.Movie;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepoository movieObj;

	@Override
	public String update(Integer mid,String name, float rating) {
		Optional<Movie> movie=movieObj.findById(mid);
		if(movie.isPresent())
		{
			Movie m=movie.get();
			m.setMname(name);
			m.setMrating(rating);
			movieObj.save(m);
			return "inserted the rec succesfully:: "+m.getMid();
		}
		else
		
		return "record not found to update";
	}

	@Override
	public String RegisteredStatus(Movie movie) {

		System.out.println("*********" + movieObj.getClass() + Arrays.toString(movieObj.getClass().getInterfaces()));
		System.out.println("Before inserting record::" + movie);

		Movie movie1 = movieObj.save(movie);
		System.out.println("After inserting record::" + movie1);

		return "Movie ticket is registered with the id::" + movie1.getMid();
	}

	@Override
	public long FindCount(Movie movie) {
		return movieObj.count();
	}

	@Override
	public boolean ChechWhetherExists(Movie movie) {
		return movieObj.existsById(8);
	}

	@Override
	public void delete(Movie movie) {
		movieObj.deleteById(3);
		

	}

	@Override
	public Iterable<Movie> selectall() {
		return movieObj.findAll();
	}

	@Override
	public Iterable<Movie> SearchByIds(List<Integer> identity) {

		return movieObj.findAllById(identity);
	}

	@Override
	public Optional<Movie> SearchById(Integer identity) {

		return Optional.of(movieObj.findById(identity).orElse(new Movie()));

	}

	@Override
	public String deleteMultiplerecords(Iterable<Integer> id) {
		movieObj.deleteAllById(id);
		return "records got deleted";	
		}

	@Override
	public String clearAll() {
		movieObj.deleteAll();
		return "All reords got deleted";
	}

	@Override
	public String insertmultplerecords(List<Movie> movie) {
		movieObj.saveAll(movie);
		return "inserted multiple records";
	}

}
