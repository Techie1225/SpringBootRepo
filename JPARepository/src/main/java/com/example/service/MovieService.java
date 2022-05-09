package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.entity.Movie;

public interface MovieService {

	public String removeRecordsById(List id);
	

}
