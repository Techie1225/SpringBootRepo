
  package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ProfileDetails;
import com.example.repository.IProfileRepo;

@Service 
  public class MovieServiceImpl implements IMovieService{
  
  @Autowired 
IProfileRepo profobj;

 

@Override
public int saveTheRecord() {
	ProfileDetails pd=new ProfileDetails(null,"Chetan",List.of("Yashwanth","Mahendra"),Set.of(9876543219L,8765432199L),
			Map.of("AdCard","98745632","PAN","A3456Bddv"));
	
	profobj.save(pd);
	return profobj.save(pd).getEid();
	
}



@Override
public List<ProfileDetails> selectTheRecords() {
	
	return profobj.findAll();
}
  
  
  
  }
 