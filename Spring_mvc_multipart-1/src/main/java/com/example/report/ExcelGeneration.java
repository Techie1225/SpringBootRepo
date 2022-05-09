package com.example.report;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.example.dto.job_seeker_info;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

@Component("excel_report")
public class ExcelGeneration extends AbstractXlsView{
	int i=1;
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		i=1;
		
		
		Sheet sheet=workbook.createSheet("excelRep");
		
		
		List<job_seeker_info> list=(List<job_seeker_info>) model.get("jobseeker_data");
		System.out.println(list);
		
		Row row=sheet.createRow(0);
		row.createCell(1).setCellValue("ID");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("ADDRESS");
		row.createCell(4).setCellValue("RESUME PATH");
		row.createCell(5).setCellValue("PHOTO PATH");
		
		list.forEach(emp->{
		Row row1=sheet.createRow(i);
			row1.createCell(1).setCellValue(emp.getJsid());
			row1.createCell(2).setCellValue(emp.getJsname());
			row1.createCell(3).setCellValue(emp.getAddress());
			row1.createCell(4).setCellValue(emp.getResumepath());
			row1.createCell(5).setCellValue(emp.getPhotopath());	
			i++;
			System.out.println(i);
		});
		
		 
	}

}
