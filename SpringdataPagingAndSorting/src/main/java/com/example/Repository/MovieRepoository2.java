package com.example.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Movie;

public interface MovieRepoository2 extends JpaRepository<Movie, Integer> {

}
