package com.example.BatchWriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("writer")
public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> relations) throws Exception {
	relations.forEach(System.out::print);
		
	}

}
