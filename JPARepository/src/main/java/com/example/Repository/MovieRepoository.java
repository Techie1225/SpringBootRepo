package com.example.Repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Movie;

public interface MovieRepoository extends JpaRepository<Movie, Integer> {
	
	
	  @Query("from Movie where mid>=?1 and mid<=?2") 
	  public List<Movie> serchTherecord(int min,int middle,int max);
	 
}
