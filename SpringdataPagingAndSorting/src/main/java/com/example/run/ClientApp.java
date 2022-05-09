package com.example.run;





import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.entity.Movie;
import com.example.service.MovieService;



@Component
public class ClientApp implements CommandLineRunner {
	Logger Chetan=LogManager.getLogger(ClientApp.class);
	
	@Autowired 
	MovieService serviceMovieObj;
	
	@Override
	public void run(String... args) throws Exception {
		
		Page page=serviceMovieObj.Pagination(0,5,true,"year","mname");
		List li=page.getContent();
		li.forEach(Chetan::info);
		
		Movie movie=new Movie();
		movie.setYear("2019");
		movie.setMrating(4);
		
		serviceMovieObj.SearchMovies(movie, true, "mname").forEach(Chetan::info);
	}	

}
