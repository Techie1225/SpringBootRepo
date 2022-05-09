package com.example.Runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entity.ProfileDetails;
import com.example.repository.IProfileRepo;



@Service
public class Runner implements CommandLineRunner {
	
	@Autowired
	IProfileRepo repoObj;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***************************************************");
		ProfileDetails pd=new ProfileDetails("Chetan", LocalDate.of(1998, 03,30),/*LocalTime.of(10, 30, 30),*/LocalDateTime.of(1998, 03,30,10, 30));
	System.out.println(repoObj.save(pd));

	}

}
