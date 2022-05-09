package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.Repository.MovieRepoository;
import com.example.entity.Movie;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepoository movieObj;

	@Override
	public String removeRecordsById(List id) {
		List list=movieObj.findAllById(id);
		long count=list.size();
		
			movieObj.deleteAllByIdInBatch(id);
			return count+" records got deleted";
	}

	
	
	

}
