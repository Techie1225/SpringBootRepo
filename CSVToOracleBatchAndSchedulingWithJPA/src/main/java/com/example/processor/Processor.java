package com.example.processor;

import com.example.entity.IExamResult;
import com.example.entity.OExamResult;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<IExamResult, OExamResult> {
	

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		OExamResult oExamResult=new OExamResult();
		if(item.getPercentage()<10) {
			oExamResult.setId(item.getId());
			oExamResult.setDob(LocalDate.parse(item.getDob()));
			oExamResult.setPercentage(item.getPercentage());
			oExamResult.setSemester(item.getSemester());
			oExamResult.setStatus("fail");
			
			return oExamResult;
		}
		else {
			oExamResult.setId(item.getId());
			oExamResult.setDob(LocalDate.parse(item.getDob()));
			oExamResult.setPercentage(item.getPercentage());
			oExamResult.setSemester(item.getSemester());
			oExamResult.setStatus("pass");
			return oExamResult;
		}
		
	}

}
