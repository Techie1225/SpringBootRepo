
  package com.example.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.DrivingLicense;
import com.example.entity.ProfileDetails;
import com.example.repository.IProfileRepo;

@Service 
  public class MovieServiceImpl implements IMovieService{
  
  @Autowired 
IProfileRepo profobj;

 

@Override
public String saveTheRecord() {

	
		Random rand=new Random();

		DrivingLicense dl=new DrivingLicense(5l,"twoWheeler",LocalDate.now());
	
		ProfileDetails pd = new ProfileDetails("BJNPV457N",23.0f,rand.nextInt(1000));
		pd.setDLicense(dl);
	/*
	 * ProfileDetails pd=new ProfileDetails(); pd.setAge(19f);
	 * pd.setTouristName("Chitti");
	 */
	profobj.save(pd);
	return profobj.save(pd).getId();
	
}















  
  
  
  }
 