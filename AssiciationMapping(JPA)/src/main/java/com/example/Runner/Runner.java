package com.example.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.service.MovieServiceImpl;



@Service
public class Runner implements CommandLineRunner {
	@Autowired
	MovieServiceImpl movieObj;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("***************************************************");
	
				//System.out.println(movieObj.saveTheRecord());
		System.out.println(movieObj.deleteMethod());
	
				movieObj.selectTheRecords().forEach(System.out::println);
	}

}
