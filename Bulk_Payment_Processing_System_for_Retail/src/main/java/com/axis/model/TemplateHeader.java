package com.axis.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
public class TemplateHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int templateId;
	
	private String templateName;
	
	private LocalDate creationDate;
	
	@OneToMany(mappedBy = "templateHeader", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("templateHeader")
	private List<TemplateDetails> templateDetails;

	public TemplateHeader() {
		super();
	}

	public TemplateHeader(int templateId, String templateName, LocalDate creationDate,
			List<TemplateDetails> templateDetails) {
		super();
		this.templateId = templateId;
		this.templateName = templateName;
		this.creationDate = creationDate;
		this.templateDetails = templateDetails;
	}

	public int getTemplate_id() {
		return templateId;
	}

	public void setTemplate_id(int template_id) {
		this.templateId = template_id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate localDate) {
		this.creationDate = localDate;
	}

	public List<TemplateDetails> getTemplateDetails() {
		return templateDetails;
	}

	public void setTemplateDetails(List<TemplateDetails> templateDetails) {
		this.templateDetails = templateDetails;
	}
	

}
