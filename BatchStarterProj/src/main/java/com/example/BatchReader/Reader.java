package com.example.BatchReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("reader")
public class Reader implements ItemReader<String> {
	public Reader() {
		System.out.println("0 param :: reader()");
	}

	String[] relation=new String[]{"Mother","Father","Sister","friends"};
	int count=0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if(count<relation.length)
		{
			return relation[count++];
		}
		
		return null;
	}

}
