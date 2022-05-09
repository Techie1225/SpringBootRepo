package com.example.Repository;



import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Movie;

public interface MovieRepoository extends PagingAndSortingRepository<Movie, Integer> {

}
