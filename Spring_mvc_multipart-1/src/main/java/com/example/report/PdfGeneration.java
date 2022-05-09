package com.example.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.example.dto.job_seeker_info;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Component("pdf_report")
public class PdfGeneration extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<job_seeker_info> list =(List<job_seeker_info>) map.get("jobseeker_data");
		Paragraph para=new Paragraph("PortableFile",new Font(Font.ITALIC,Font.BOLD));
		document.add(para);
		Table tb= new Table(5,((ArrayList)list).size());
		for(job_seeker_info emp:list){
			
				tb.addCell(emp.getJsid().toString());
		
					tb.addCell(emp.getJsname());
					tb.addCell(emp.getAddress());
					tb.addCell(emp.getResumepath());
					tb.addCell(emp.getAddress());	
		}
		document.add(tb);	
	}

}
