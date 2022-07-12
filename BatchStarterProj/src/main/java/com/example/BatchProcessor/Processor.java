package com.example.BatchProcessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("processor")
public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String relation) throws Exception {
		System.out.println("In ProcessorS");
		System.out.println(relation);
		
		if(relation.equalsIgnoreCase("mother")) {
			System.out.println("Sridevi "+relation+" Of Chetan");	
			return "Sridevi "+relation+" Of Chetan";
		}
		else if(relation.equalsIgnoreCase("Father")) {
			System.out.println("Venkateswarlu "+relation+" Of Chetan");			
			return "Venkateswarlu "+relation+" Of Chetan";
		}
		else if(relation.equalsIgnoreCase("Sister")) {
			System.out.println("Chitti "+relation+" Of Chetan");	
			return "Chitti "+relation+" Of Chetan";
		}
		else if(relation.equalsIgnoreCase("friENDS")) {
			System.out.println("Yaswanth,Mahindra "+relation+" Of Chetan");			
			return "Yaswanth,Mahindra "+relation+" Of Chetan";
		}
		return null;
	}

	

}
