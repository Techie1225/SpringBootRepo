
  package com.example.service;



import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Medals;
import com.example.entity.Sports;
import com.example.entity.person;
import com.example.repository.IMedals;
import com.example.repository.IPerson;
import com.example.repository.ISports;

@Service 
  public class MovieServiceImpl implements IMovieService{
  
  
  @Autowired 
  IPerson personobj;

@Override
public  Long saveTheRecords() {
	
	Sports sport1=new Sports(new Random().nextInt(2000),"Thowball", new String[] {"Ball","net","players"});
	Sports sport2=new Sports(new Random().nextInt(),"badminton", new String[] {"Racket","cock","net","players"});
	
	Medals medals1=new Medals("CWG","Gold","2020events","Tokyo");
	Medals medals2=new Medals("AsianGames","Gold","2020events","Tokyo");
	Medals medals3=new Medals("Olympics","Gold","2020events","Tokyo");
	
	person person1=new person(new Random().nextLong(),"Sachin","Chennai",Set.of(sport1,sport2), Map.of("medals1",medals1,"medals2",medals2,"medals3",medals3));
	
	
	
	return personobj.save(person1).getPid();
}

@Override
public List<person> picTheRecords() {
	
	return personobj.findAll();
}

 


  
  }
 