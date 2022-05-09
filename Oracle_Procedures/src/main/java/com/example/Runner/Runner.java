package com.example.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.entity.Movie;
import com.example.service.IMovieService;

@Component
public class Runner implements CommandLineRunner {
	@Autowired 
	IMovieService serviceObj;
	



	@Override
	public void run(String... args) throws Exception {
		
		List<Movie> list=serviceObj.searchById(10,100);
		for(Movie i:list) {
			System.out.println(i.getMid()+" "+i.getMname()+" "+i.getMrating()+" "+i.getYear());
		}

	}
	
	
}
