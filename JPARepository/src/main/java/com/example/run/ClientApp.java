package com.example.run;





import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.Repository.MovieRepoository;
import com.example.entity.Movie;
import com.example.service.MovieService;



@Component
public class ClientApp implements CommandLineRunner {
	Logger Chetan=LogManager.getLogger(ClientApp.class);
	
	
	/*
	 * @Autowired MovieService serviceMovieObj;
	 */
	
	@Autowired
MovieRepoository movieObj;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * List li=new ArrayList(); li.add(47); li.add(null);
		 * 
		 * System.out.println(serviceMovieObj.removeRecordsById(li));
		 */
		
		  Movie movie=new Movie(); //movie.setMname("Dhee"); movie.setYear("1998");
		  movie.setMrating(null);
		  
		  System.out.println(movieObj.save(movie).getMid()+" record inserted");
		 
		
		  System.out.println("**********************");
		 
		  System.out.println( movieObj.serchTherecord(71,72,75));
		 
		
	}

}
