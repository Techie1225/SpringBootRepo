package com.example.Runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.entity.Medals;
import com.example.entity.Sports;
import com.example.entity.person;
import com.example.service.MovieServiceImpl;



@Service
public class Runner implements CommandLineRunner {
	//Logger log=new Logger(Runner.class);
	
	@Autowired
	MovieServiceImpl movieServiceImpl;

	@Override
	public void run(String... args) throws Exception {
	
		
		//System.out.println(movieServiceImpl.saveTheRecords());		
		System.out.println(movieServiceImpl.picTheRecords());
			List<person> li=movieServiceImpl.picTheRecords();
			
			li.forEach(x->{
				System.out.println("{");
				System.out.println("_id : "+x.getPid());
				System.out.println("name : "+x.getName());
				System.out.println("adress : "+x.getAdress());
				Set<Sports> s=x.getSports();	
				
				System.out.println("sports : [");
				s.forEach(temp->{
					System.out.println("{");
				System.out.println("_id : "+temp.getSid());
				System.out.println("}");
				});
				System.out.println("]");
				
				Map<String,Medals> m=x.getMedals();

				System.out.println("medals : {");
				m.forEach((t,med)->{
					System.out.println(t +": {");
				System.out.println("_id : "+med.getMid());
				System.out.println("}");
				
				});
				System.out.println("}");
	});

}
}
