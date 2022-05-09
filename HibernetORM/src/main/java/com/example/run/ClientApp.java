package com.example.run;





import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
		// TODO Auto-generated method stub
		/*Movie movie=new Movie();
		movie.setMname("Shyam Singaroy");
		movie.setMrating(4);
		movie.setYear("2021");
		try {
		System.out.println(serviceMovieObj.RegisteredStatus(movie));
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("-------------------------");
		System.out.println("Total number of tickets registered till now :: "+serviceMovieObj.FindCount(movie));
		System.out.println("-------------------------");
System.out.println(serviceMovieObj.ChechWhetherExists(movie));
//serviceMovieObj.delete(movie);
	System.out.println(serviceMovieObj.selectall());
	
	Iterable<Movie> m=serviceMovieObj.selectall();
	for(Movie i:m)
	{
		System.out.println(i);
	}
	System.out.println("555555555555555555");
	m.forEach(xyz->System.out.println(xyz));
	m.forEach(System.out::println);
	Arrays.asList(m).stream().forEach(System.out::println);
	

	List<Integer> li=new ArrayList();
	li.add(1);
	li.add(2);
	li.add(3);
	li.add(4);
	Iterable<Movie> movie2=serviceMovieObj.SearchByIds(li);

	for(Movie i:movie2)
	{
		Optional<Movie> y=Optional.of(i);
		System.out.println(y);
		if(y.isEmpty())
		{
			throw new IllegalArgumentException("Record not found");
		}
			
			
		else
			
{
			System.out.println(i);
		
			
		}
			
	}
	System.out.println(serviceMovieObj.SearchByIds(Arrays.asList(5,6,7,8)));
	System.out.println(serviceMovieObj.SearchByIds(List.of(9,10,11,12)));
	
	System.out.println(serviceMovieObj.SearchById(80/2));*/
		/*
		 * System.out.println(serviceMovieObj.update(6,"RRR",4.5f));
		 * 
		 * Iterable<Movie> li= serviceMovieObj.selectall();
		 * li.forEach(System.out::println); Chetan.info("&&&&&&&&&&&&&&&&&&&&&&&&&");
		 * li.forEach(xyz->Chetan.info(xyz)); li.forEach(Chetan::info);
		 */
		
		/*
		 * Iterable<Integer>li=List.of(25,26,27,28);
		 * System.out.println(serviceMovieObj.deleteMultiplerecords(li));
		 * System.out.println(serviceMovieObj.deleteMultiplerecords(List.of(21,22,23)));
		 * 
		 * Iterable<Movie> li1= serviceMovieObj.selectall();
		 * li1.forEach(System.out::println);
		 */
	 //System.out.println(serviceMovieObj.clearAll());
	 
	 System.out.println(serviceMovieObj.insertmultplerecords(List.of(new Movie("Alibaba",3f,"2020"),
			 								new Movie("Blibaba",4f,"2021"),
			 								new Movie("Clibaba",5f,"2022"))));
	 
	}

	
	
	

}
