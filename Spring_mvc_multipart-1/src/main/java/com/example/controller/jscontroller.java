package com.example.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.job_seeker_data;
import com.example.dto.job_seeker_info;
import com.example.service.job_service;

import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class jscontroller {
	
	@Autowired
	job_service jservice;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/")
	public String home() {
		System.out.println(" in controller");
		return "home";
		
	}
	
	@GetMapping("/repo")
	public String generateReport(Map<String, Object> map, @RequestParam("type") String filename ) {
		System.out.println("jscontroller.generateReport()");
		List<job_seeker_info> list=jservice.FetchTheRecords();
		map.put("jobseeker_data", list);
		if(filename.equalsIgnoreCase("excel"))
			return "excelGeneration";
		else
			return "pdf_report";
		
	}
	
	@GetMapping("/add")
	public String addjs(@ModelAttribute("jsdata") job_seeker_data jdata ) {
		System.out.println("in get add");
		return "Register";
		
	}
	@PostMapping("/add")
	public String addingtodb(@ModelAttribute("jsdata") job_seeker_data jdata, Map<String,Object> map ) throws IOException {
		System.out.println("in post add");
		String filestore=env.getRequiredProperty("upload.store");
		File file=new File(filestore);
		if(!file.exists())
			file.mkdir();
		MultipartFile resumefile=jdata.getJsresume();
		MultipartFile photofile=jdata.getJsphoto();
		InputStream resumeinstream=resumefile.getInputStream();
		InputStream photoinstream=photofile.getInputStream();
		String resumefilename=resumefile.getOriginalFilename();
		String photofilename=photofile.getOriginalFilename();
		System.out.println(resumefilename);
		OutputStream resumeout=new FileOutputStream(file.getAbsolutePath()+"\\"+resumefilename);
		OutputStream photoout=new FileOutputStream(file.getAbsolutePath()+"\\"+photofilename);
		IOUtils.copy(photoinstream, photoout);
		IOUtils.copy(resumeinstream, resumeout);
	job_seeker_info jobinfo=new job_seeker_info();
		jobinfo.setJsname(jdata.getJsname());
		jobinfo.setAddress(jdata.getJsaddress());
		jobinfo.setResumepath(file.getAbsolutePath()+"\\"+resumefilename);
		jobinfo.setPhotopath(file.getAbsolutePath()+"\\"+photofilename);
		
		jservice.savethedata(jobinfo);
		List<job_seeker_info> entry=jservice.FetchTheRecords();
		map.put("entry", entry);
		return "showreport";
		
	}
	
	@GetMapping("/jsList")
	public String ShowTheList(Map<String,Object> map) {
		List<job_seeker_info> entry=jservice.FetchTheRecords();
		map.put("entry", entry);
		return "showreport";	
	}
	
	/*
	 * @GetMapping("/download") public String downloadMeth(@RequestParam("jsid")
	 * Integer Id,
	 * 
	 * @RequestParam("type") String type ) throws IOException {
	 * System.out.println("jscontroller.downloadMeth()"); String filepath=null;
	 * if(type.equalsIgnoreCase("resume")) {
	 * filepath=jservice.getResumePathById(Id); } else {
	 * filepath=jservice.getPhotoPathById(Id); }
	 * 
	 * File file=new File(filepath);
	 * 
	 * InputStream io= new FileInputStream(file); OutputStream os=new
	 * FileOutputStream("C:\\Users\\mouni\\Downloads\\"+file.getName());
	 * System.out.println(file.getName()); IOUtils.copy(io,os); io.close();
	 * os.close(); return "home"; }
	 */
	
	@GetMapping("/download") 
	public ResponseEntity<Object> downloadMeth(@RequestParam("jsid") Integer Id,
			@RequestParam("type") String type ) throws IOException  {

		String filepath=null;
		if(type.equalsIgnoreCase("resume")) {
			filepath=jservice.getResumePathById(Id);
		}
		else {
			filepath=jservice.getPhotoPathById(Id);
		}
		
		File file=new File(filepath);
		System.out.println("jscontroller.downloadMeth()");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file)); 
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName())); 
	//	headers.add("Cache-Control", "no-cache, no-store, must-revalidate"); 
	//	headers.add("Pragma", "no-cache"); headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity =ResponseEntity.ok().headers(headers) .contentLength(file.length()) .contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
	
}
