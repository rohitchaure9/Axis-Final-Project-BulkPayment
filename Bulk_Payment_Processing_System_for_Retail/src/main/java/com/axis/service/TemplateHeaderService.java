package com.axis.service;

import java.util.List;
import java.util.Optional;

import com.axis.model.TemplateDetails;
import com.axis.model.TemplateHeader;

public interface TemplateHeaderService {
	
	    void saveTemplateHeader(TemplateHeader templateHeader);
	    Optional<TemplateHeader> getTemplateHeaderById(int id);
	    List<TemplateHeader> getAllTemplateHeaders();
	    String deleteTemplateHeader(int id);
	    List<TemplateDetails> getTemplateDetailsByTemplateId(int templateId);
	


}