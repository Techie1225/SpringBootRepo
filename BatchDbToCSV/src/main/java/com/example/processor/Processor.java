package com.example.processor;

import com.example.entity.ExamResult;

public class Processor implements org.springframework.batch.item.ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()<20)
			return item;
		return null;
	}

}
