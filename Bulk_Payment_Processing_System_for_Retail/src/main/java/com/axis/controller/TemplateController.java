package com.axis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.axis.model.TemplateDetails;
import com.axis.model.TemplateHeader;
import com.axis.service.TemplateHeaderService;

@RestController
@RequestMapping("/api/template")
@CrossOrigin("*")
public class TemplateController {
	
	
	@Autowired
	private TemplateHeaderService headerService;
	
	@PostMapping("/createtemplate")
	public ResponseEntity<String> saveTemplate(@RequestBody TemplateHeader templateHeader) {
		headerService.saveTemplateHeader(templateHeader);
		return new ResponseEntity<>("Template saved successfully", HttpStatus.OK);
	}
	
	@GetMapping("/templatedetails/{templateId}")
    public ResponseEntity<List<TemplateDetails>> getTemplateDetailsByTemplateId(@PathVariable int templateId) {
        return new ResponseEntity<List<TemplateDetails>> (headerService.getTemplateDetailsByTemplateId(templateId),HttpStatus.OK);
	}
	
	@GetMapping("/templateheaders")
    public ResponseEntity<List<TemplateHeader>> getAllTemplateHeader() {
        return new ResponseEntity<List<TemplateHeader>> (headerService.getAllTemplateHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/templateheader/{headerId}")
    public ResponseEntity<Optional<TemplateHeader>> getTemplateHeader(@PathVariable int headerId) {
        return new ResponseEntity<Optional<TemplateHeader>> (headerService.getTemplateHeaderById(headerId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{templateId}")
	public ResponseEntity<String> deleteTemplateHeader(@PathVariable int templateId) {
        return new ResponseEntity<String> (headerService.deleteTemplateHeader(templateId),HttpStatus.OK);
	}

}
